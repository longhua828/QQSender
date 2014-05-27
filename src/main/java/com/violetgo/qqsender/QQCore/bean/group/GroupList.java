package com.violetgo.qqsender.QQCore.bean.group;

import java.util.List;

public class GroupList {
	private List<Object> gmasklist;
	private List<Group> gnamelist;
	private List<Object> gmarklist;

	public List<Object> getGmarklist() {
		return gmarklist;
	}

	public void setGmarklist(List<Object> gmarklist) {
		this.gmarklist = gmarklist;
	}

	public List<Object> getGmasklist() {
		return gmasklist;
	}

	public void setGmasklist(List<Object> gmasklist) {
		this.gmasklist = gmasklist;
	}

	public List<Group> getGnamelist() {
		return gnamelist;
	}

	public void setGnamelist(List<Group> gnamelist) {
		this.gnamelist = gnamelist;
	}
}
