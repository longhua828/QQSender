package com.violetgo.qqsender.helper;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.violetgo.qqsender.QQCore.Constant;

/**
 * this class can return qq number and ptwebqq hash.
 * this class should use online hash function
 * */
public class FriendsHashHelper {

	private static Pattern PATTERN = Pattern.compile("(http://.*?mq.js.*?)\"");
	
	private String getJSURL(){
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.get(Constant.SMARTQQLOGINPAGE, null, null, "utf-8", 20 * 1000);
		String html = new String(response.getBody());
		Matcher matcher = PATTERN.matcher(html);
		if(matcher.find()){
			return matcher.group(1);
		}
		return null;
	}
	
	
	private String getJSContent(String jsurl){
//		HttpHelper helper = new HttpHelper();
//		HTTPResponse response = helper.get(jsurl, null, null, "utf-8", 20 * 1000);
//		String jsbody = new String(response.getBody());
//		int index = jsbody.indexOf("\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\"");
//		String functionLHelf = jsbody.substring(0,index);
//		String functionRHelf = jsbody.substring(index);
//		int li = functionLHelf.lastIndexOf("function");
//		int ri = functionRHelf.indexOf("},");
		
		return "u=function(x,K){this.s=x||0;this.e=K||0},s=function(x,K){x+=\"\";var L=[];L[0]=x>>24&255;L[1]=x>>16&255;L[2]=x>>8&255;L[3]=x&255;for(var T=[],V=0;V<K.length;++V)T.push(K.charCodeAt(V));V=[];for(V.push(new u(0,T.length-1));V.length>0;){var R=V.pop();if(!(R.s>=R.e||R.s<0||R.e>=T.length))if(R.s+1==R.e){if(T[R.s]>T[R.e]){var Z=T[R.s];T[R.s]=T[R.e];T[R.e]=Z}}else{Z=R.s;for(var U=R.e,ba=T[R.s];R.s<R.e;){for(;R.s<R.e&&T[R.e]>=ba;){R.e--;L[0]=L[0]+3&255}if(R.s<R.e){T[R.s]=T[R.e];R.s++;L[1]=L[1]*13+43&255}for(;R.s<R.e&&T[R.s]<=ba;){R.s++;L[2]=L[2]-3&255}if(R.s<R.e){T[R.e]=T[R.s];R.e--;L[3]=(L[0]^L[1]^L[2]^L[3]+1)&255}}T[R.s]=ba;V.push(new u(Z,R.s-1));V.push(new u(R.s+1,U))}}T=[\"0\",\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\",\"A\",\"B\",\"C\",\"D\",\"E\",\"F\"];V=\"\";for(R=0;R<L.length;R++){V+=T[L[R]>>4&15];V+=T[L[R]&15]}return V}";
	}

	public String getHash(String qq,String ptwebqq){
		String jsurl = getJSURL();
		String jscontent = null;
		if(jsurl!=null){
			jscontent = getJSContent(jsurl);
		}
		Context cx = Context.enter();
		try {
			Scriptable scope = cx.initStandardObjects();
			cx.evaluateString(scope, jscontent, null, 1, null);
			String str = "s('" + qq + "','" + ptwebqq + "');";
			Object result = cx.evaluateString(scope, str, null, 1, null);
			return (result.toString());
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			Context.exit();
		}
		return null;
	}
}
