package com.violetgo.qqsender.helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HTTPResponse {

	private byte[] body;
	private int code;
	private HashMap<String, String> header = new HashMap<String, String>();
	private List<String> cookies = new LinkedList<String>();

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public HashMap<String, String> getHeader() {
		return header;
	}

	public void putHead(String key,String value){
		header.put(key, value);
	}
	
	public void setHeader(HashMap<String, String> header) {
		this.header = header;
	}

	public List<String> getCookies() {
		return cookies;
	}

	public void setCookies(List<String> cookies) {
		this.cookies = cookies;
	}
	
	public void addCookies(String cookie){
		cookies.add(cookie);
	}

}
