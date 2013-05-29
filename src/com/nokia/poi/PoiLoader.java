package com.nokia.poi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.nokia.log4j.Log4jTest;

public class PoiLoader {
	static final Logger logger = Logger.getLogger(Log4jTest.class);
	public static List<Poi> loadFromRdfFile(File rdfFile){
		
		List<Poi> poiList = new ArrayList<Poi>();
		
		BasicConfigurator.configure();
		try {
			BufferedReader br = new BufferedReader(new FileReader(rdfFile));
			char delimiter = '\t';
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				int preIndex = 0;
				int index = line.indexOf(delimiter);
				int fieldIdx = 0;
				String id = "";
				float lat = -200;
				float lon = -200;
				while(index >= 0){
					if(fieldIdx == 0) id = line.substring(preIndex,index);
					if(fieldIdx == 6) {
						if(line.substring(preIndex,index).trim().length() > 0){
							lat = Float.parseFloat(line.substring(preIndex,index)) /100000;
						}
						
					}
					if(fieldIdx == 7) {
						if(line.substring(preIndex,index).trim().length() > 0){
							lon = Float.parseFloat(line.substring(preIndex,index)) /100000;
						}
					}
					preIndex = index;
					index = line.indexOf(delimiter, index+1);
					fieldIdx ++;
				}
				
				poiList.add(new Poi(id, lat, lon));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return poiList;
	}
}
