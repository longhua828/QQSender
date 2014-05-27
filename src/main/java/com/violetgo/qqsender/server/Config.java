package com.violetgo.qqsender.server;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static int PORT = 7176;
	public static long QQ = 2257510634L;
	public static String PASSOWRD = "iflytek";
	public static String LOG4JCONFIG = "log4j.properties";  
	
	public static boolean init(){
		
		Properties prop = new Properties();
		InputStream in = null;
		try {
			//init conifg if have any error.
			//it's mean read config error and will use defalut config
			in = new BufferedInputStream(new FileInputStream("qqserver.properties"));
			prop.load(in);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		Config.LOG4JCONFIG = prop.getProperty("log4j", "log4j.properties");
		Config.PORT = Integer.parseInt(prop.getProperty("port", "7176"));
		Config.QQ = Long.parseLong(prop.getProperty("qq", "2257510634"));
		Config.PASSOWRD = prop.getProperty("password", "iflytek");
		
		return true;
	}
	
}
