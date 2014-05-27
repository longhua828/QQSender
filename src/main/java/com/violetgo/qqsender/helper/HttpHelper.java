package com.violetgo.qqsender.helper;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class HttpHelper {

    private HttpClient httClient = new HttpClient();

    public boolean post(String url, String requestData, StringBuffer responseData, String encoding, int timeOut) {
        PostMethod method = new PostMethod(url);

        httClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);

        httClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);

        httClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);

        method.addRequestHeader("Connection", "close");

        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);

        try {
            method.setRequestEntity(new StringRequestEntity(requestData, "text/xml", "utf-8"));
            httClient.executeMethod(method);
            String respString = method.getResponseBodyAsString();
            responseData.append(respString);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            method.releaseConnection();
        }

        return true;
    }

    public static String listToString(List list,String spiltStr){
		if(list==null) return "";
		
		StringBuffer result = new StringBuffer();
		for(Object cur:list){
			String[] kv = cur.toString().split("=");
			if(!kv[1].trim().equals(""))
				result.append(cur.toString()+spiltStr);
		}
		return result.toString();
	}

    public HTTPResponse get(String url,List<String> cookies,String referer, String encoding, int timeOut) {
    	HTTPResponse response = new HTTPResponse();
    	
        HttpMethod method = new GetMethod(url);

        httClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
        
        httClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);

        httClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        method.addRequestHeader("Connection", "close");
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);
        method.setFollowRedirects(false);
        if(cookies!=null){
        	method.addRequestHeader("Cookie",listToString(cookies,""));
        }
        if(referer!=null){
        	method.addRequestHeader("Referer",referer);
        }
        
        try {
            httClient.executeMethod(method);

            response.setBody(method.getResponseBody());
            response.setCode(method.getStatusCode());
            for(Header header:method.getResponseHeaders()){
            	if(header.getName().equalsIgnoreCase("Set-Cookie")){
            		response.addCookies(header.getValue().split(";")[0]+";");
            	}else{
            		response.putHead(header.getName(), header.getValue());
            	}
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            return response;
        }
        finally {
            method.releaseConnection();
        }

        return response;
    }
    
    public HTTPResponse post(String url,HashMap<String,String> requestheader,String content,List<String> cookies,String referer, String encoding, int timeOut) {
        PostMethod method = new PostMethod(url);
        HTTPResponse response = new HTTPResponse();
        
        httClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
        httClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
        method.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:24.0) Gecko/20100101 Firefox/24.0");
        method.addRequestHeader("Accept", "*/*");
        method.addRequestHeader("Accept-Language","zh-CN,zh;q=0.8,en;q=0.6");
        method.addRequestHeader("Content-Length", content.length()+"");
        method.addRequestHeader("Connection", "keep-alive");
        method.addRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        
        if(cookies!=null){
        	method.addRequestHeader("Cookie",listToString(cookies,""));
        }
        if(referer!=null){
        	method.addRequestHeader("Referer",referer);
        }
        method.setRequestBody(content);
        try {
            httClient.executeMethod(method);

            response.setBody(method.getResponseBody());
            response.setCode(method.getStatusCode());
            for(Header header:method.getResponseHeaders()){
            	if(header.getName().equalsIgnoreCase("Set-Cookie")){
            		response.addCookies(header.getValue().split(";")[0]+";");
            	}else{
            		response.putHead(header.getName(), header.getValue());
            	}
            }
        }
        catch (Exception e) {
            return response;
        }
        finally {
            method.releaseConnection();
        }

        return response;
    }
    
    public boolean post_des(String url, byte[] requestData, StringBuffer responseData, String encoding, int timeOut) {
        PostMethod method = new PostMethod(url);
        httClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);

        method.addRequestHeader("Connection", "close");

        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);

        try {
        	method.setRequestEntity(new ByteArrayRequestEntity(requestData));
            httClient.executeMethod(method);
            String respString = method.getResponseBodyAsString();
            responseData.append(respString);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            method.releaseConnection();
        }

        return true;
    }
    
    public boolean get_page(String url, StringBuffer responseData, HashMap<String, String> params, String encoding, int timeOut)
    {
        HttpMethod method = new GetMethod(url);

        httClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);

        httClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);

        httClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);

        method.addRequestHeader("Connection", "close");

        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);

        try {
            httClient.executeMethod(method);

            InputStream inputStream = method.getResponseBodyAsStream();
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String respString = "";

            while ((respString = bufferedReader.readLine()) != null) {
            	responseData.append(respString);
            }

            //keep page state code
            params.put("PageState",	String.valueOf(method.getStatusCode()));
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            method.releaseConnection();
        }

        return true;
    }
    
    public byte[] post4ossp(String url, byte[] requestData, String encoding, int timeOut) {
        PostMethod method = new PostMethod(url);
        httClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
        httClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
        httClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        method.addRequestHeader("Connection", "close");
        method.addRequestHeader("Accept-Encoding", "gzip");
        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);

        try {
        	method.setRequestEntity(new ByteArrayRequestEntity(requestData));
            httClient.executeMethod(method);
            return method.getResponseBody();
        }
        catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
        finally {
            method.releaseConnection();
        }
    }
    
    public byte[] post4uploadossp(String url, byte[] requestData, String encoding, int timeOut) {
        PostMethod method = new PostMethod(url);
        httClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
        httClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
        httClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        method.addRequestHeader("Connection", "close");
        method.addRequestHeader("Content-Type","multipart/mixed;boundary=\"=====iflytek_ossp2.0_blc1.0_nextpart=====\"");
//        method.addRequestHeader("boundary","=====iflytek_ossp2.0_blc1.0_nextpart=====");

        method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);

        try {
        	method.setRequestEntity(new ByteArrayRequestEntity(requestData));
            httClient.executeMethod(method);
            return method.getResponseBody();
        }
        catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
        finally {
            method.releaseConnection();
        }
    }
    
    public boolean get_file(String url, String outFilePath, String encoding, int timeOut)
    {

    	 HttpMethod method = new GetMethod(url);

         httClient.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);

         httClient.getHttpConnectionManager().getParams().setSoTimeout(timeOut);

         httClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);

         method.addRequestHeader("Connection", "close");

         method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);
         FileOutputStream outFileStream = null;
         try {
             httClient.executeMethod(method);

             outFileStream = new FileOutputStream(outFilePath);
             InputStream inputStream = method.getResponseBodyAsStream();
             
             byte[] readBuf = new byte[1024];
             int readCount = -1;
             while ((readCount = inputStream.read(readBuf)) != -1) {
            	 outFileStream.write(readBuf, 0, readCount);
             }
         }

         catch (Exception e) {
             return false;
         }
         finally {
        	 method.releaseConnection();
        	 if (outFileStream != null)
        	 {
        		 try {
					outFileStream.close();
				} catch (IOException e) {
		             return false;
				}
        	 }
            
         }
         
         return true;
    }
}