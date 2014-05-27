package com.violetgo.qqsender.QQCore;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.Gson;
import com.violetgo.qqsender.QQCore.bean.SendResult;
import com.violetgo.qqsender.QQCore.bean.msg.MessageResult;
import com.violetgo.qqsender.helper.HTTPResponse;
import com.violetgo.qqsender.helper.HttpHelper;
import com.violetgo.qqsender.helper.LogHelper;

public class PushMsg {
	private QQClient client = null;

	public PushMsg(QQClient client){
		this.client = client;
	}
	
	private HTTPResponse sendGroupMsg(long gid,String content){
    	String pollContent="{\"group_uin\":"+gid+",\"content\":\"[\\\""+content+"\\\",[\\\"font\\\",{\\\"name\\\":\\\"宋体\\\",\\\"size\\\":10,\\\"style\\\":[0,0,0],\\\"color\\\":\\\"000000\\\"}]]\",\"face\":594,\"clientid\":"+client.getClientID()+",\"msg_id\":98800001,\"psessionid\":\""+client.getPsessionid()+"\"}";
	    try {
			pollContent = URLEncoder.encode(pollContent,"utf-8");
			pollContent = ("r="+pollContent);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	    HttpHelper helper = new HttpHelper();
	    HTTPResponse response = helper.post(Constant.GROUPPOLLURL,null,pollContent,client.cookies(),Constant.REFERER, "utf-8", 20 * 1000);
		return response;
    }
	
	//get poll and to object
	public SendResult pushGroupMsgByName(String name,String msg) throws UnsupportedEncodingException{
		long gid = client.getGid(name);
		if(gid==-1 || gid==0)   return null;
		HTTPResponse response = sendGroupMsg(gid,msg);
		if(response.getBody()==null){
			return null;
		}
		String json = new String(response.getBody(),"utf-8");
		Gson gson = new Gson();
		try{
			SendResult result = gson.fromJson(json, SendResult.class);
			return result;
		}catch(Exception e){
			LogHelper.Error("push GroupMsgByName is error and back json is "+json);
		}
		return null;
	}
	
	public SendResult pushGroupMsgByQQ(long qq,String msg){
		long gid = client.getGid4number(qq+"");
		if(gid==-1 || gid==0)  return null;
		HTTPResponse response = sendGroupMsg(gid,msg);
		if(response.getBody()==null){
			return null;
		}
		String json = null;
		try{
			json = new String(response.getBody(),"utf-8");
		}catch(Exception e){
			json = new String(response.getBody());
		}
		Gson gson = new Gson();
		try{
			SendResult result = gson.fromJson(json, SendResult.class);
			return result;
		}catch(Exception e){
			LogHelper.Error("push GroupMsgByQQ is error and back json is "+json);
		}
		return null;
	}
	
	
	private HTTPResponse sendFriendMsg(long fid,String content){
		String pollContent="{\"to\":"+fid+",\"content\":\"[\\\""+content+"\\\",[\\\"font\\\",{\\\"name\\\":\\\"宋体\\\",\\\"size\\\":10,\\\"style\\\":[0,0,0],\\\"color\\\":\\\"000000\\\"}]]\",\"face\":594,\"clientid\":"+client.getClientID()+",\"msg_id\":80910004,\"psessionid\":\""+client.getPsessionid()+"\"}";
	    try {
			pollContent = URLEncoder.encode(pollContent,"utf-8");
			pollContent = ("r="+pollContent);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	    HttpHelper helper = new HttpHelper();
	    HTTPResponse response = helper.post(Constant.FRIENDPOLLURL,null,pollContent,client.cookies(),Constant.REFERER, "utf-8", 20 * 1000);
		return response;
    }
	
	public SendResult pushFriendMsgByName(String name,String msg) throws UnsupportedEncodingException{
		long fid = client.getFid(name);
		if(fid==-1 || fid==0) return null;
		HTTPResponse response = sendFriendMsg(fid,msg);
		if(response.getBody()==null){
			return null;
		}
		String json = new String(response.getBody(),"utf-8");
		Gson gson = new Gson();
		try{
			SendResult result = gson.fromJson(json, SendResult.class);
			return result;
		}catch(Exception e){
			LogHelper.Error("push FriendMsgByName is error and back json is "+json);
		}
		return null;
	}
	
	public SendResult pushFriendMsgByQQ(long qq,String msg) {
		long fid = client.getFid4number(qq+"");
		if(fid==-1 || fid==0) return null;
		HTTPResponse response = sendFriendMsg(fid,msg);
		if(response.getBody()==null){
			return null;
		}
		String json = null;
		try{
			json = new String(response.getBody(),"utf-8");
		}catch(Exception e){
			json = new String(response.getBody());
		}
		Gson gson = new Gson();
		try{
			SendResult result = gson.fromJson(json, SendResult.class);
			return result;
		}catch(Exception e){
			LogHelper.Error("push FriendMsgByQQ is error and back json is "+json);
		}
		return null;
	}
	
}
