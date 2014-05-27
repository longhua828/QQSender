package com.violetgo.qqsender.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.violetgo.qqsender.thrift.Msg;
import com.violetgo.qqsender.thrift.MsgSender;
import com.violetgo.qqsender.thrift.MsgType;
import com.violetgo.qqsender.thrift.MsgSender.Client;

public class MsgClient {
	
	public static boolean push(String host,int port,Msg msg) {
		
		TTransport transport = new TFramedTransport(new TSocket(host,port,2000));
		try {
			transport.open();
		} catch (TTransportException e) {
			e.printStackTrace();
			return false;
		}
		try {
			TProtocol protocol = new TCompactProtocol(transport);
			Client client = new MsgSender.Client(protocol);

			try {
				if(msg!=null){
					return client.send(msg);
				}
				return false;
			} catch (TException e) {
				e.printStackTrace();
				return false;
			}
		} finally {
			transport.close();
		}
	}
	
	/**
	 * @param a is send args
	 * a[0] is host ip
	 * a[1] is port
	 * a[2] is type 1 is mean send to friend and 2 is mean group 
	 * a[3] is friend name or group name
	 * a[4] is send message
	 * */
	public static void main(String []a){
		if(a.length!=5){
			System.err.println("your input arg is error");
			System.err.println("arg[0] is host ip");
			System.err.println("arg[1] is port");
			System.err.println("arg[2] is type 1 is mean send to friend and 2 is mean group ");
			System.err.println("arg[3] is friend qq or group qq");
			System.err.println("arg[4] is send message");
			return ;
		}
		
		Msg msg = new Msg();
		if(a[2].equals("1")){
			msg.type = MsgType.FRIEND;
		}else{
			msg.type = MsgType.GROUP;
		}
		msg.to_id = a[3];
		msg.msg = a[4];
		boolean isOK = push(a[0],Integer.parseInt(a[1]),msg);
		System.out.println("send msg "+isOK);
	}
	
}
