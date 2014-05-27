package com.violetgo.qqsender.QQCore.bean;


public class SendResult {
	private String retcode;
	private String result;
	
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	@Override
	public String toString() {
		return "SendResult [retcode=" + retcode + ", result=" + result + "]";
	}
	
}
