package com.violetgo.qqsender;

import com.google.gson.Gson;
import com.violetgo.qqsender.QQCore.bean.msg.MessageResult;

public class TestReflectMsg {
	
	public static void main(String []a){
		String content = "{\"retcode\":0,\"result\":[{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21573,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203698,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":3442414242,\"seq\":2059,\"time\":1389947016,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u8BF7\u6C42\u5404\u4F4D\u670B\u53CB\u6367\u573A\uFF0C\u5E2E\u5FD9\u5237\u5237\u7F51\u7AD9\uFF0C\u5927\u6570\u636E\u4E2D\u56FD\uFF01\r\u518D\u6B64\u611F\u8C22\u5404\u4F4D\uFF01\rhttp://www.bigdatas.cn\r \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21570,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203697,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":3442414242,\"seq\":2056,\"time\":1389893961,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":9,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"Tahoma\"}],\" \u0000\n\u0000\u0000\u0000\u0000\u0002\u5B8B\u4F53\r\"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21571,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203696,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":3442414242,\"seq\":2057,\"time\":1389893961,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":9,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"Tahoma\"}],\" \u0000\n\u0000\u0000\u0000\u0000\u0002\u5B8B\u4F53\r\"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21568,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203695,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":3442414242,\"seq\":2054,\"time\":1389869554,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u8C01\u5982\u679C\u4E3E\u529E\u62A5\u540D\u6D3B\u52A8 \u4EFB\u6211\u4EA4\u7ED9\u6211\u5427 \u6211\u5E2E\u4F60\u4EEC\u5B8C\u6210 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21567,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203694,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":3442414242,\"seq\":2053,\"time\":1389869191,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u6625\u98CE\u5728\u4E0D \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21566,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203693,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":2545929865,\"seq\":2052,\"time\":1389869116,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[1,0,0],\"name\":\"\u9ED1\u4F53\"}],\"\rhadoop\u5B66\u4E60\u8D44\u6599\u66F4\u65B0\u4E86\u5206\u4EAB\rhttp://bbs.itcast.cn/forum-122-1.html?140116wwtqunzxy \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21572,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203692,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":1373172113,\"seq\":2058,\"time\":1389945004,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":11,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u5927\u5BB6\u597D\uFF0C\u7FA4\u91CC\u6709\u505A\u7F51\u7AD9\u626B\u53F7\u7684\u5417\uFF1F\u79C1\u804A\uFF0C\u8C22\u8C22 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21565,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203691,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":442594321,\"seq\":2051,\"time\":1389852207,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":10,\"color\":\"0000ff\",\"style\":[1,0,0],\"name\":\"\u9ED1\u4F53\"}],\"http://www.cnblogs.com/guoshiandroid/p/3521898.html \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":21569,\"from_uin\":953503073,\"to_uin\":340194658,\"msg_id2\":203690,\"msg_type\":43,\"reply_ip\":176886353,\"group_code\":1959620525,\"send_uin\":3442414242,\"seq\":2055,\"time\":1389893961,\"info_seq\":284078981,\"content\":[[\"font\",{\"size\":9,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"Tahoma\"}],\" \u0000\n\u0000\u0000\u0000\u0000\u0002\u5B8B\u4F53\r\"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54641,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449295,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":1920313078,\"seq\":106407,\"time\":1390011378,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"face\",57],[\"face\",57],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54643,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449294,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":1920313078,\"seq\":106409,\"time\":1390011400,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u6211\u5C31\u770B\u770B\",[\"face\",13],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54640,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449293,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":2770207919,\"seq\":106406,\"time\":1390011378,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"face\",109],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54638,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449292,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106404,\"time\":1390011355,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u9A9A\u540E\u00B7\u00B7 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54636,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449291,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106402,\"time\":1390011349,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u8FD8\u5728\u8FD9\u56B7\u56B7\u00B7\u00B7 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54635,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449290,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106401,\"time\":1390011343,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u4F60\u81EA\u5DF1\u6389\u7684\u00B7\u00B7 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54634,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449289,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106400,\"time\":1390011314,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\":microphone:\u6211\u8981\u9A9A\u7684\u5F88\u9A9A\uFF0C\u9A9A\u7684\u5F88\u9A9A\u54E6 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54633,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449288,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":1392076,\"seq\":106399,\"time\":1390011309,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"cface\",{\"name\":\"{b0de88b5-2167-d00f-46a2-0e5277557921}.jpg\",\"file_id\":2284203254,\"key\":\"cbXgunVwSARJbygU\",\"server\":\"123.151.47.107:8080\"}],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54632,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449287,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106398,\"time\":1390011289,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"cface\",{\"name\":\"{A5A98519-90B8-52DD-3857-96E1C79479A3}.gif\",\"file_id\":3105997099,\"key\":\"cuz2EjzaNSjFPmGj\",\"server\":\"124.89.102.231:8000\"}],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54631,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449286,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":2770207919,\"seq\":106397,\"time\":1390011260,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"cface\",{\"name\":\"{6B43DCDE-DAA7-9F6A-A3F9-410B7B9EFDF8}.jpg\",\"file_id\":2436533909,\"key\":\"Sdh8SVtW3yxuCcbx\",\"server\":\"124.89.102.231:8000\"}],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54630,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449285,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":1920313078,\"seq\":106396,\"time\":1390011229,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u8FD9\u4E2A\u53EF\u4EE5\u6709\",[\"face\",57],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54642,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449284,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":1920313078,\"seq\":106408,\"time\":1390011391,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u8D77\u5185\u8BA7\u7684\u8D76\u811A\",[\"face\",73],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54629,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449283,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106395,\"time\":1390011227,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u5927\u5BB6\u597D\uFF0C\u6211\u662F\u65B0\u4EBA\uFF0C\u8BF7\u591A\u591A\u6307\u6559 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54639,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449282,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":2770207919,\"seq\":106405,\"time\":1390011372,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u8FD9\u4E2A\u989C\u8272\u6211\u559C\u6B22 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54628,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449281,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":1920313078,\"seq\":106394,\"time\":1390011214,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u4ED6\u53EF\u4EE5\u8BF4\u4E0D\u884C\",[\"face\",57],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54637,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449280,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106403,\"time\":1390011352,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u4E22\u4EBA\u4E0D\u00B7~\uFF1F~ \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54627,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449279,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106393,\"time\":1390011208,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"cface\",{\"name\":\"{E21AD885-B0AA-8680-2B17-2D9F106556E2}.jpg\",\"file_id\":705496361,\"key\":\"cuz2EjzaNSjFPmGj\",\"server\":\"120.198.201.86:8000\"}],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54626,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449278,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":2770207919,\"seq\":106392,\"time\":1390011206,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\":unamused: \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54625,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449277,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":1392076,\"seq\":106391,\"time\":1390011190,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u54C8\u54C8  \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54624,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449276,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":2770207919,\"seq\":106390,\"time\":1390011186,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u6211\u6B63\u4F4E\u7740\u5934\u542C\u3002\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54623,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":449275,\"msg_type\":43,\"reply_ip\":180028749,\"group_code\":647803749,\"send_uin\":302108462,\"seq\":106389,\"time\":1390011182,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"cface\",{\"name\":\"{329EEC50-CBA3-B667-4B2E-F7D3E4400D62}.jpg\",\"file_id\":579798634,\"key\":\"cuz2EjzaNSjFPmGj\",\"server\":\"120.198.201.89:8000\"}],\"\r\u7537\u4EBA\u600E\u4E48\u53EF\u4EE5\u8BF4\u4E0D\u884C\u5462\uFF1F\u5973\u4EBA\u600E\u4E48\u53EF\u4EE5\u8BF4\u968F\u4FBF\u5462\uFF1F \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":31894,\"from_uin\":1990558459,\"to_uin\":340194658,\"msg_id2\":321034,\"msg_type\":43,\"reply_ip\":176488537,\"group_code\":647803749,\"send_uin\":1920313078,\"seq\":106409,\"time\":1390011400,\"info_seq\":231312903,\"content\":[[\"font\",{\"size\":10,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u6211\u5C31\u770B\u770B\",[\"face\",13],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54155,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387937,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1127965381,\"seq\":310846,\"time\":1390008163,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":15,\"color\":\"000000\",\"style\":[0,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"face\",46],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54154,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387936,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":4055151732,\"seq\":310845,\"time\":1389989769,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":12,\"color\":\"ff0000\",\"style\":[1,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"face\",0],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54151,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387935,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310842,\"time\":1389989417,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u8FD9\u51E0\u5929\u3002\u3002\u5C31\u8981\u5199 8 \u4F4D\u7684\u673A\u5668\u7A0B\u5E8F\u3002\u3002\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54152,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387934,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310843,\"time\":1389989428,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u77AC\u95F4\u56DE\u5230\u539F\u59CB\u3002\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54150,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387933,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310841,\"time\":1389989406,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u54C0\u5BB6\u6211\u524D\u4E9B\u65E5\u5B50\u8FD8\u5728\u5199 64\u4F4D\u7684\u7A0B\u5E8F\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54148,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387932,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310839,\"time\":1389989385,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u6574\u4E2A\u4EBA\u7684\u90FD\u4E0D\u597D\u4E86\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54145,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387931,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":4055151732,\"seq\":310836,\"time\":1389989053,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":12,\"color\":\"ff0000\",\"style\":[1,0,0],\"name\":\"\u5B8B\u4F53\"}],\"\u52C3\u8D77\u7ED9\u4ED6\u98DE\u673A\u676F\u73A9\u5457 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54144,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387930,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":4055151732,\"seq\":310835,\"time\":1389989010,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":12,\"color\":\"ff0000\",\"style\":[1,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"face\",97],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54143,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387929,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310834,\"time\":1389988961,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u770B\u5979\u4E00\u5929\u4EC0\u4E48\u65F6\u5019\u52C3\u8D77\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54141,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387927,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":3108237769,\"seq\":310832,\"time\":1389988894,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":15,\"color\":\"ff0000\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],[\"face\",13],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54153,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387926,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310844,\"time\":1389989511,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],[\"cface\",{\"name\":\"{B805841E-6A86-9AF7-E24A-4A9E87D55007}.jpg\",\"file_id\":776998967,\"key\":\"VykwveW4mYtuquQU\",\"server\":\"123.151.149.144:8000\"}],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54140,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387925,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310831,\"time\":1389988836,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u73A9\u5355\u7247\u673A\u73A9\u4E86\u4E00\u665A\u4E0A\u4E86\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54149,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387924,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":4055151732,\"seq\":310840,\"time\":1389989403,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":12,\"color\":\"ff0000\",\"style\":[1,0,0],\"name\":\"\u5B8B\u4F53\"}],\"..... \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54139,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387923,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310830,\"time\":1389988828,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],[\"cface\",{\"name\":\"{060DD38C-6ED6-5131-CFB2-74394226C20C}.jpg\",\"file_id\":678563684,\"key\":\"VykwveW4mYtuquQU\",\"server\":\"123.151.149.144:8000\"}],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54147,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387922,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310838,\"time\":1389989380,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u81F3\u4ECE\u63A5\u4E86\u8FD9\u4E2A \u7F8E\u56FD\u4E00\u5BB6\u7A7F\u6234\u8BBE\u5907\u7684\u533B\u9662\u7684\u7814\u53D1\u9879\u76EE  \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54138,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387921,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":4055151732,\"seq\":310829,\"time\":1389988271,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":12,\"color\":\"ff0000\",\"style\":[1,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"face\",1],\" \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54146,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387920,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310837,\"time\":1389989360,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"\u54CE \u8BF4\u771F\u7684\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54137,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387919,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":859187194,\"seq\":310828,\"time\":1389988260,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"ff0080\",\"style\":[1,1,0],\"name\":\"\u9ED1\u4F53\"}],[\"cface\",{\"name\":\"{DF341364-A2CD-C47B-FE97-7A4719AAB25D}.jpg\",\"file_id\":2735190356,\"key\":\"pHzKV5FEr3vGAKhS\",\"server\":\"123.151.149.144:8000\"}],\"\u7B11\u7684\u8FD9\u4E48\u574F \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54142,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387918,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":1075246987,\"seq\":310833,\"time\":1389988952,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":10,\"color\":\"8000ff\",\"style\":[0,0,0],\"name\":\"\u5FAE\u8F6F\u96C5\u9ED1\"}],\"z\u7B49\u6211\u5355\u7247\u673A\u641E\u5B9A\u4E86\u3002 \u5C31\u505A\u4E2A \u8001\u516C\u52C3\u8D77\u68C0\u6D4B\u4EEA\u3002 \"]}},{\"poll_type\":\"group_message\",\"value\":{\"msg_id\":54136,\"from_uin\":4215091481,\"to_uin\":340194658,\"msg_id2\":387917,\"msg_type\":43,\"reply_ip\":176488465,\"group_code\":993705685,\"send_uin\":4055151732,\"seq\":310827,\"time\":1389988222,\"info_seq\":8033525,\"content\":[[\"font\",{\"size\":12,\"color\":\"ff0000\",\"style\":[1,0,0],\"name\":\"\u5B8B\u4F53\"}],[\"face\",73],\" \"]}}]}";
		Gson gson = new Gson();
		MessageResult msg = gson.fromJson(content, MessageResult.class);
		System.out.print(msg);
	}
	
}