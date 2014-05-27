package com.violetgo.qqsender;

import com.violetgo.qqsender.QQCore.PushMsg;
import com.violetgo.qqsender.QQCore.QQClient;

public class TestClient {

	public static void main(String[] args) {
		
		QQClient client = new QQClient(2257510634L,"gaowei5192");
		client.login();

		PushMsg push = new PushMsg(client);
//		push.pushGroupMsgByName("Doit项目组","大家好 我是机器人....");
//		push.pushFriendMsgByName("violetgo", "你好 master!");
//		push.pushGroupMsgByQQ(155377284,"大家好 我是机器人....");
		push.pushFriendMsgByQQ(340194658, "你好 master!");
	}

}
