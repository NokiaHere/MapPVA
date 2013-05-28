package com.nokia.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {
	static final Logger logger = Logger.getLogger(Log4jTest.class);
	@Test
	public void test() {
		BasicConfigurator.configure();
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
	}
}



