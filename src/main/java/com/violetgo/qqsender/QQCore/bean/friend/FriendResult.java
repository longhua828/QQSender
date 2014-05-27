package com.violetgo.qqsender.QQCore.bean.friend;


//{"retcode":0,"result":{"gmasklist":[],"gnamelist":[{"flag":16777217,"name":"Doit项目组","gid":297667055,"code":1150176263}],"gmarklist":[]}}
public class FriendResult {
	private String retcode;
	private FriendList result;

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public FriendList getResult() {
		return result;
	}

	public void setResult(FriendList result) {
		this.result = result;
	}

}
