package com.violetgo.qqsender.server;

import org.apache.thrift.TException;

import com.violetgo.qqsender.QQCore.PushMsg;
import com.violetgo.qqsender.QQCore.QQClient;
import com.violetgo.qqsender.QQCore.bean.SendResult;
import com.violetgo.qqsender.helper.LogHelper;
import com.violetgo.qqsender.thrift.Msg;
import com.violetgo.qqsender.thrift.MsgType;
import com.violetgo.qqsender.thrift.MsgSender.Iface;

public class MsgSenderImpl implements Iface {

	private PushMsg pusher = null;
	public MsgSenderImpl(QQClient client){
		pusher = new PushMsg(client);
	}
	
	@Override
	public boolean send(Msg msg) throws TException {
		SendResult reslut = null;
		if(msg.type==MsgType.FRIEND){
			reslut = pusher.pushFriendMsgByQQ(Long.parseLong(msg.getTo_id()), msg.getMsg());
		}else if(msg.type==MsgType.GROUP){
			reslut = pusher.pushGroupMsgByQQ(Long.parseLong(msg.getTo_id()), msg.getMsg());
		}

		LogHelper.Info("send to "+msg.getTo_id()+"  and msg is  "+msg.getMsg() +"  and sendresult is "+reslut);
		return true;
	}

	@Override
	public boolean ping() throws TException {
		// ignore it
		return true;
	}

}
