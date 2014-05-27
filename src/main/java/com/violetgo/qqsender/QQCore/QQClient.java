package com.violetgo.qqsender.QQCore;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.violetgo.qqsender.QQCore.bean.friend.FriendInfo;
import com.violetgo.qqsender.QQCore.bean.friend.FriendList;
import com.violetgo.qqsender.QQCore.bean.friend.FriendResult;
import com.violetgo.qqsender.QQCore.bean.group.Group;
import com.violetgo.qqsender.QQCore.bean.group.GroupList;
import com.violetgo.qqsender.QQCore.bean.group.GroupResult;
import com.violetgo.qqsender.QQCore.bean.uin.UinResult;
import com.violetgo.qqsender.helper.FriendsHashHelper;
import com.violetgo.qqsender.helper.HTTPResponse;
import com.violetgo.qqsender.helper.HttpHelper;
import com.violetgo.qqsender.helper.LogHelper;

public class QQClient {

	private Random rd = new Random();
	private long clientID = rd.nextInt(100000000);
	private String psessionid = null;
	private String vfwebqq = null;
	private HashMap<String, String> cookies = new HashMap<String, String>();
	private long uid;
	private String password;
	
	private boolean enableSendMsgToFriends = true;
	private HashMap<String,Long> group = new HashMap<String, Long>();
	private HashMap<String,Long> friends = new HashMap<String, Long>();
	private HashMap<String,Long> friendMap = new HashMap<String, Long>();
	private HashMap<String,Long> groupMap = new HashMap<String, Long>();

	public boolean isEnableSendMsgToFriends() {
		return enableSendMsgToFriends;
	}

	public QQClient(long uid, String password) {
		this.uid = uid;
		this.password = password;
	}

	public boolean login(){
		QQLogin login = new QQLogin();
		HTTPResponse response = login.login(clientID, uid, password);
		if(response==null || response.getBody()==null) {
			LogHelper.Error("login catch error");
			return false;
		}
		
		String body;
		try {
			body = new String(response.getBody(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			body = new String(response.getBody());
		}
		Pattern p = Pattern.compile("\"psessionid\":\"(\\w+)\"");
		Matcher m = p.matcher(body);
		if (m.find()) {
			this.psessionid = m.group(1);
		}

		p = Pattern.compile("\"vfwebqq\":\"(\\w+)\"");
		m = p.matcher(body);
		if (m.find()) {
			this.vfwebqq = m.group(1);
		}
		
		if(psessionid==null || vfwebqq==null) {
			LogHelper.Error("login catch error psessionid==null or vfwebqq==null");
			return false;
		}
		
		for (String cur : response.getCookies()) {
			String[] kv = cur.split("=");
			if (kv.length == 2 && !kv[1].substring(0,kv[1].length()-1).trim().equals("")) {
				cookies.put(kv[0], kv[1]);
			}
		}

		if(!init()){
			return false;
		}
		
		Puller temp = new Puller();
		temp.setClient(this);
		temp.start();
		
		return true;
	}

	public HashMap<String, String> getCookies() {
		return cookies;
	}

	public void setCookies(HashMap<String, String> cookies) {
		this.cookies = cookies;
	}

	public List<String> cookies(){
		List<String> result = new ArrayList<String>();
		if(cookies!=null){
			for(String cur:cookies.keySet()){
				result.add(cur+"="+cookies.get(cur));
			}
		}
		return result;
	}
	
	//
	private boolean getGroup() {
		String content = "r=%7B%22vfwebqq%22%3A%22" + vfwebqq + "%22%7D";// post数据;
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.post(Constant.GETGROUP, null, content, cookies(), Constant.REFERER, "utf-8", 20 * 1000);
		String json;
		try {
			json = new String(response.getBody(),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			json = new String(response.getBody());
		}

		Gson gson = new Gson();
		try {
			GroupResult result = gson.fromJson(json, GroupResult.class);
			LogHelper.Error("get getGroup json sucess");
			return initGroupCache(result);
		} catch (Exception e) {
			e.printStackTrace();
			LogHelper.Error("getGroup is error and back json is "+json);
			return false;
		}
	}
	
	private boolean initGroupCache(GroupResult group) {
		if (group == null) {
			return false;
		}
		GroupList glist = group.getResult();
		if (glist == null) {
			return false;
		}
		List<Group> groups = glist.getGnamelist();
		if (groups == null)
			return false;
		for (Group cc : groups) {
			this.group.put(cc.getName().toLowerCase(), cc.getGid());
			
			String qq = uinToQQ(cc.getCode()+"");
			if(qq!=null){
				this.groupMap.put(qq, cc.getGid());
				LogHelper.Info("group "+cc.getName()+" get qq number is "+qq);
			}else{
				//later update!
				LogHelper.Info("group "+cc.getName()+" get qq number is error!!!");
			}
		}
		return true;
	}

	
	private boolean getFriend() {
		FriendsHashHelper hashHelper = new FriendsHashHelper();
		String ptwebqq = cookies.get("ptwebqq");
		ptwebqq = ptwebqq.substring(0,ptwebqq.length()-1);
		String hash = hashHelper.getHash(uid+"", ptwebqq);
		if(hash==null){
			LogHelper.Error("cant send friend msg");
			enableSendMsgToFriends = false;
			return false;
		}
		String content = "r=%7B%22vfwebqq%22%3A%22" + vfwebqq + "%22%2C%22hash%22%3A%22"+hash+"%22%7D";// post数据;
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.post(Constant.FRIENDS, null, content, cookies(), Constant.REFERER, "utf-8", 20 * 1000);
		if(response.getBody()==null) return false;
		
		String json;
		try {
			json = new String(response.getBody(),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			json = new String(response.getBody());
		}

		Gson gson = new Gson();
		try {
			FriendResult result = gson.fromJson(json, FriendResult.class);
			if(result.getResult()==null){
				LogHelper.Error("cant send friend msg");
				enableSendMsgToFriends = false;
				return false;
			}
			
			return initFriendCache(result);
		} catch (Exception e) {
			e.printStackTrace();
			LogHelper.Error("getFriend is error and back json is "+json);
		}
		return false;
	}
	
	private boolean initFriendCache(FriendResult friends) {
		if (friends == null) {
			return false;
		}
		FriendList flist = friends.getResult();
		if (flist == null) {
			return false;
		}
		List<FriendInfo> friendlist = flist.getInfo();
		if (friendlist == null)
			return false;
		
		for (FriendInfo cinfo : friendlist) {
			this.friends.put(cinfo.getNick().toLowerCase(), cinfo.getUin());
			String qq = uinToQQ(cinfo.getUin()+"");
			if(qq!=null){
				this.friendMap.put(qq, cinfo.getUin());
				LogHelper.Info("friends "+cinfo.getNick()+" get qq number is "+qq);
			}else{
				//later update!
				LogHelper.Info("friends "+cinfo.getNick()+" get qq number is error!!!");
			}
		}
		return true;
	}
	
	/**
	 * case uin to qq number both friend and group
	 * */
	private String uinToQQ(String uin) {
		String url = "http://s.web2.qq.com/api/get_friend_uin2?tuin="+uin+"&type=1&vfwebqq="+vfwebqq+"&t="+System.currentTimeMillis();
		HttpHelper helper = new HttpHelper();
		HTTPResponse response = helper.get(url, cookies(), Constant.REFERER, "utf-8", 20 * 1000);
		if(response.getBody()==null) return null;
		
		String json = new String(response.getBody());

		Gson gson = new Gson();
		try {
			UinResult result = gson.fromJson(json, UinResult.class);
			return result.getResult().getAccount();
		} catch (Exception e) {
			e.printStackTrace();
			LogHelper.Error("get uinToQQ is error and back json is "+json);
		}
		return null;
	}
	
	private boolean init() {
		boolean groupresult = getGroup();
		boolean frientresult = getFriend();
		LogHelper.Info("login finish!  and group is " + groupresult + "  ,frientresult is  "+frientresult);
		return groupresult&frientresult;
	}

	public long getClientID() {
		return clientID;
	}

	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	public String getPsessionid() {
		return psessionid;
	}

	public void setPsessionid(String psessionid) {
		this.psessionid = psessionid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getGid(String groupName) {
		groupName = groupName.toLowerCase();
		return group.get(groupName);
	}

	public long getFid(String friendName) {
		friendName = friendName.toLowerCase();
		return friends.get(friendName);
	}

	public long getGid4number(String number) {
		return groupMap.get(number);
	}

	public long getFid4number(String number) {
		return friendMap.get(number);
	}
	
}
