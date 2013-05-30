package com.nokia.poi;

import java.io.File;
import java.util.List;

import org.junit.Test;
import com.nokia.config.Config;


public class PoiLoaderTest {
	@Test
	public void test() {
		System.out.println("load POIs fron TWN 2011Q4");
		String poiFilePath = Config.getDataPath() +"TWN2011Q4\\rdf_poi\\" + 
	    "a__pre-production-namenode_services_navteq_productverification_rdf_raw_6554155_TWN2011Q4_CORE_ADAS_W5AM114M0WW5000QAACS_ALLFiles_corerdf_rdf_poi.txt";
		List<Poi> poiList = PoiLoader.loadFromRdfFile(new File(poiFilePath));
		for (Poi poi : poiList) {
//			System.out.println(poi);
		}
		System.out.println("Totally, there are " + poiList.size() + " POIs");
		System.out.println();
		
		System.out.println("load POIs fron TWN 2012Q1");
		poiFilePath = Config.getDataPath() +"TWN2012Q1\\" +  "rdf_poi.txt";
		poiList = PoiLoader.loadFromRdfFile(new File(poiFilePath));
		for (Poi poi : poiList) {
//			System.out.println(poi);
		}
		System.out.println("Totally, there are " + poiList.size() + " POIs");
		System.out.println();
		
	}

}
