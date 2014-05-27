package com.violetgo.qqsender;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestLength {
	
	public static void main(String []a) throws UnsupportedEncodingException{
		String text = "r:{\"group_uin\":297667055,\"content\":\"[\\\"抓个包\\\",[\\\"font\\\",{\\\"name\\\":\\\"宋体\\\",\\\"size\\\":10,\\\"style\\\":[0,0,0],\\\"color\\\":\\\"000000\\\"}]]\",\"face\":594,\"clientid\":53999199,\"msg_id\":98800001,\"psessionid\":\"8368046764001d636f6e6e7365727665725f77656271714031302e3133392e372e31363400006b2600000371036e0400eae08e866d0000000a404672674f784d6b4b366d00000028e4517c4abf1b492dab14e3084b322436d363b0790c957bd97bd9f12433a24b5b5e81bff08e65c321\"}";
		text = URLEncoder.encode(text,"utf-8");
		System.out.println(text.length());
	}
	
}
