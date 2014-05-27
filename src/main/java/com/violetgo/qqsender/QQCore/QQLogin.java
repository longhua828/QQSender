package com.violetgo.qqsender.QQCore;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.violetgo.qqsender.helper.HTTPResponse;
import com.violetgo.qqsender.helper.HttpHelper;
import com.violetgo.qqsender.helper.LogHelper;
import com.violetgo.qqsender.helper.QQEncryptor;

public class QQLogin {
	
	private static String SIGURL = "https://ui.ptlogin2.qq.com/cgi-bin/login?daid=164&target=self&style=5&mibao_css=m_webqq&appid=1003903&enable_qlogin=0&no_verifyimg=1&s_url=http%3A%2F%2Fweb2.qq.com%2Floginproxy.html&f_url=loginerroralert&strong_login=1&login_state=10&t=20130903001";
	private static String CHECKURL = "https://ssl.ptlogin2.qq.com/check?uin=<uid>&appid=1003903&r=0.2842747748363763&js_ver=10049&js_type=0&login_sig=<login_sig>&u1=http%3A%2F%2Fweb2.qq.com%2Floginproxy.html";
	private static String LOGINURL = "https://ssl.ptlogin2.qq.com/login?u=<uid>&p=<ps>&verifycode=<verifycode>&webqq_type=10&remember_uin=1&login2qq=1&aid=1003903&u1=http%3A%2F%2Fweb2.qq.com%2Floginproxy.html%3Flogin2qq%3D1%26webqq_type%3D10&h=1&ptredirect=0&ptlang=2052&daid=164&from_ui=1&pttype=1&dumy=&fp=loginerroralert&action=2-17-120524&mibao_css=m_webqq&t=1&g=1&js_type=0&js_ver=10049&login_sig=<login_sig>";
	private static String LOGIN = "http://d.web2.qq.com/channel/login2";
	private static String REFERER = "http://d.web2.qq.com/proxy.html?v=20110331002&callback=1&id=2" ;
	
	/**
	 * open login page and get login_sig..
	 * @throws UnsupportedEncodingException 
	 * */
	private String getLogin_Sig(){
		String url = SIGURL;
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.get(url,null,null,"utf-8", 2000);
		if(response.getBody()==null) return null;
		String login_sig = null;
    	Pattern p = Pattern.compile("g_login_sig=.*\\)");
        Matcher m = p.matcher(new String(response.getBody()));
        if(m.find()){
        	login_sig=m.group().split("\"")[1];
        }
		
		return login_sig;
	}
	
	/**
	 * get check number
	 * */
	private HTTPResponse checkLogin(long user,String login_sig){
		String url = CHECKURL.replace("<uid>", user+"");
		url = url.replace("<login_sig>", login_sig);
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.get(url, null,null,"utf-8", 5000);
		return response;	
	}
	
	/**
	 * first login
	 * */
	private HTTPResponse login_1(long user,String password,String verifycode,List<String> cookie,String referer,String login_sig){
		HttpHelper helper = new HttpHelper();
		String url = LOGINURL.replace("<uid>", user+"");
		url = url.replace("<ps>", QQEncryptor.encrypt(user, password, verifycode));
		url = url.replace("<verifycode>", verifycode);
		url = url.replace("<login_sig>", verifycode);
		HTTPResponse response = helper.get(url,cookie,referer, "utf-8", 5000);
		return response;
	}
	
	private HTTPResponse redirect(String url,List<String> cookie){
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.get(url,null,null, "utf-8", 5000);
		return response;
	}
	
	
	private String getLoginContent(long clientid,String cookie){
		String[] ptwebqqs = cookie.split("ptwebqq=");
        String ptwebqq = ptwebqqs[1].split(";")[0];
        String content = "{\"ptwebqq\":\"" + ptwebqq + "\",\"clientid\":" + clientid +",\"psessionid\":"+ "\"" + "\"" +",\"status\":\"online\"}";
        
        try{
            content = URLEncoder.encode(content, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        content ="r="+content;
        
        return content;
	}
	
	private HTTPResponse login_2(String content,List<String> cookie,String referer){
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.post(LOGIN,null,content,cookie,referer, "utf-8", 2000);
		return response;
	}
	
	/**
	 * down verifly image and wait input veriflycode 
	 * */
	private String[] getVerifyCode(long qq){
	    	String check = null;
            String imagePath="https://ssl.captcha.qq.com/getimage?aid=1003903&r=0.3318511257455748&uin="+qq;
        	String cookie = null;
            
            try {
                URL url = new URL(imagePath);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                
                if(conn.getHeaderFields().get("Set-Cookie") != null){
                	for(String s: conn.getHeaderFields().get("Set-Cookie")){
                		cookie = (s.split(";")[0]+";");
                    }
                }

                DataInputStream in = new DataInputStream(conn.getInputStream());
                DataOutputStream out = new DataOutputStream(new FileOutputStream("login-"+qq+".jpg"));
                byte[] buffer = new byte[1024];
                int count = 0;
                
                while ((count = in.read(buffer)) > 0){
                    out.write(buffer, 0, count);
                }
                out.close();
                in.close();
                conn.disconnect();

                System.out.println("请输入验证码:");
                LogHelper.Info("请输入验证码:");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String code = br.readLine();
                
                check = code.toUpperCase();
            }catch (Exception e){
                e.printStackTrace();
            }

	    	return new String[]{check,cookie};
	    }
	
	public HTTPResponse login(long clientid,long user,String password) {
		String sig = getLogin_Sig();
		if(sig==null) return null;
		
		HTTPResponse response  = checkLogin(user,sig);
		if(response.getBody()==null) return null;
		
		String verifycode = new String(response.getBody()).split(",")[1].replaceAll("'", "").replace(");", "");
		List<String> cookies = new LinkedList<String>();

		//need input verifycode
		if (verifycode.length() > 10) {
			String[] temp = getVerifyCode(user);
			verifycode = temp[0];
			cookies.add(temp[1]);
		}
		LogHelper.Info("get verifycode sucess!!" + verifycode);
		
		cookies.addAll(response.getCookies());

//		System.out.println(verifycode);
		response = login_1(user,password,verifycode,cookies,REFERER,sig);
		
		cookies.clear();
		cookies.addAll(response.getCookies());
		LogHelper.Info("first login sucess!!");
		
//		System.out.println(new String(response.getBody()));
		String loginresponse;
		try {
			loginresponse = new String(response.getBody(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			loginresponse = new String(response.getBody());
		}
		
		//if login sucess ,need redirect and get cookie!
		if(loginresponse.contains("登录成功")){
			String url = loginresponse.split(",")[2].replace("'", "");
			HTTPResponse reresponse = redirect(url,response.getCookies());
			cookies.addAll(reresponse.getCookies());
			LogHelper.Info("get redirect sucess!!");
		}else{
			LogHelper.Info("redirect error "+loginresponse);
		}
		
		//really login! 
		String content = getLoginContent(clientid,HttpHelper.listToString(cookies,""));
		response = login_2(content,cookies,REFERER);
		response.setCookies(cookies);
		try {
			LogHelper.Info("login sucess!!  "+new String(response.getBody(),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			LogHelper.Info("login sucess!!  "+new String(response.getBody()));
		}
		return response;
		
	}
	
}
