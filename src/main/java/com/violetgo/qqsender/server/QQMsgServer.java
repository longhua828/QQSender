package com.violetgo.qqsender.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.server.TThreadedSelectorServer.Args;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportFactory;

import com.violetgo.qqsender.QQCore.QQClient;
import com.violetgo.qqsender.helper.LogHelper;
import com.violetgo.qqsender.thrift.MsgSender;

public class QQMsgServer {
	public static void main(String[] args) {
		
		Config.init();
		LogHelper.Info("QQ is "+Config.QQ+"  and PASSOWRD is "+Config.PASSOWRD);
		QQClient client = new QQClient(Config.QQ,Config.PASSOWRD);
		if(!client.login()){
			LogHelper.Error("login error!!");
			return;
		}
		
		int port = Config.PORT;
		try{
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(port);
			TTransportFactory transportFactory = new TFramedTransport.Factory();
			TProtocolFactory proFactory = new TCompactProtocol.Factory();
	
			@SuppressWarnings("rawtypes")
			TProcessor processor = new MsgSender.Processor(
					new MsgSenderImpl(client));
	
			TServer server = new TThreadedSelectorServer(new Args(serverTransport)
					.protocolFactory(proFactory).transportFactory(transportFactory)
					.processor(processor));
			server.serve();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
}
