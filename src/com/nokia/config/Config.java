package com.nokia.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private static String dataFolder = null;
	static {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataFolder = prop.getProperty("datafolder");
		
	}
	public static String getDataPath(){
		return dataFolder;
	}
}
