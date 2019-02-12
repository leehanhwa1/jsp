package kr.or.ddit.util.log;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogBackTest {
	// 1. logger 선언
	//private Logger logger = LoggerFactory.getLogger(Class);
	private Logger logger = LoggerFactory.getLogger(LogBackTest.class);
	//private Logger logger = LoggerFactory.getLogger("kr.or.ddit.util.log.LogbackTest");
	//<logger name="kr.or.ddit" level="DEBUG"/>
	
	//private Logger logger = LoggerFactory.getLogger(String);
	
	public LogBackTest() {
		System.out.println("syso : test");
		logger.trace("trace" + "test");
		logger.debug("debug" + "test");
		logger.info("info" + "test");
		logger.warn("warn" + "test");
		
		//================================
		
		logger.error("error" + "test");
		logger.error("error {}, {}, {}, {}" , "test", "test2", "test3", new HashMap());
		
	}
	
	public static void main(String[] args) {
		LogBackTest logbackTest = new LogBackTest();
		
	}
}