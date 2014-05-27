package com.violetgo.qqsender.QQCore;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.violetgo.qqsender.QQCore.bean.msg.Message;
import com.violetgo.qqsender.QQCore.bean.msg.MessageResult;
import com.violetgo.qqsender.helper.LogHelper;

public class Puller extends Thread{
	private QQClient client = null;
	
	public QQClient getClient() {
		return client;
	}

	public void setClient(QQClient client) {
		this.client = client;
	}

	public void run(){
		PullMsg puller = new PullMsg(client);
		while(true){
			MessageResult result = null;
			try {
				result = puller.pull();
			} catch (UnsupportedEncodingException e) {
				LogHelper.Error("puller msg error");
			}
			if(result!=null){
				List<Message> msglist = result.getResult();
				if(msglist!=null){
					for(Message cur:msglist){
						List<Object> content = cur.getValue().getContent();
						if(content !=null && content.size()==2){
							LogHelper.Info("get msg " + content.get(1).toString());
						}
					}
				}
			}
		}
	}
}
