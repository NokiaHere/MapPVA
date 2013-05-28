package com.nokia.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class ConfigTest {

	@Test
	public void testGetDataPath() {
		System.out.println("local data folder is " + Config.getDataPath());
		try {
			BufferedReader br = new BufferedReader(new FileReader(Config.getDataPath()+"test.txt"));
			System.out.println("file content of " + Config.getDataPath()+"test.txt" + " is :");
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
