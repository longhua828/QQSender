package com.violetgo.qqsender.QQCore.bean.msg;

public class Message {
	private String poll_type;
	private MessageValue value;

	public String getPoll_type() {
		return poll_type;
	}

	public void setPoll_type(String poll_type) {
		this.poll_type = poll_type;
	}

	public MessageValue getValue() {
		return value;
	}

	public void setValue(MessageValue value) {
		this.value = value;
	}
}
