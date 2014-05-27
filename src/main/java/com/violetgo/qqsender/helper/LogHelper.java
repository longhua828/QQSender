package com.violetgo.qqsender.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.violetgo.qqsender.server.Config;

public class LogHelper {
	protected static Logger logger = Logger.getLogger(LogHelper.class.getName());

	static {
		PropertyConfigurator.configure(Config.LOG4JCONFIG);
	}

	public static void Debug(String log) {
		logger.debug(log);
	}
	
	public static void Warn(String log) {
		logger.warn(log);
	}
	
	public static void Info(String log) {
		logger.info(log);
	}
	
	public static void Error(String log) {
		logger.error(log);
	}
}
