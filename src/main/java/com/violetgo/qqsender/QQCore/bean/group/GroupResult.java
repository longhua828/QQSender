package com.violetgo.qqsender.QQCore.bean.group;

import java.util.List;

import com.violetgo.qqsender.QQCore.bean.msg.Message;

//{"retcode":0,"result":{"gmasklist":[],"gnamelist":[{"flag":16777217,"name":"Doit项目组","gid":297667055,"code":1150176263}],"gmarklist":[]}}
public class GroupResult {
	private String retcode;
	private GroupList result;

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public GroupList getResult() {
		return result;
	}

	public void setResult(GroupList result) {
		this.result = result;
	}

}
