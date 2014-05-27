package com.violetgo.qqsender.QQCore;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.violetgo.qqsender.QQCore.bean.msg.MessageResult;
import com.violetgo.qqsender.helper.HTTPResponse;
import com.violetgo.qqsender.helper.HttpHelper;
import com.violetgo.qqsender.helper.LogHelper;

public class PullMsg {
	
	private QQClient client = null;

	public PullMsg(QQClient client){
		this.client = client;
	}
	
	private HTTPResponse getPoll(){
    	String pollUrl="http://d.web2.qq.com/channel/poll2";
	    String pollContent="r=%7B%22clientid%22%3A%22"+client.getClientID()+"%22%2C%22psessionid%22%3A%22"+client.getPsessionid()+"%22%2C%22key%22%3A0%2C%22ids%22%3A%5B%5D%7D";
	    HttpHelper helper = new HttpHelper();
	    HTTPResponse response = helper.post(pollUrl,null,pollContent,client.cookies(),Constant.REFERER, "utf-8", 20 * 1000);
		return response;
    }
	
	//get poll and to object
	public MessageResult pull() throws UnsupportedEncodingException{
		HTTPResponse response = getPoll();
		if(response.getBody()==null){
			return null;
		}
		String json = new String(response.getBody(),"utf-8");
	
		Gson gson = new Gson();
		try{
			MessageResult result = gson.fromJson(json, MessageResult.class);
			return result;
		}catch(Exception e){
			LogHelper.Error("pull msg error and back json is "+json);
		}
		return null;
	}
	
}
