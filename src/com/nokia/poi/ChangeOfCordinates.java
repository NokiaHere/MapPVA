package com.nokia.poi;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.nokia.config.Config;
import com.nokia.log4j.Log4jTest;

/**
 * 
 * @author huayili
 * 
 * this class quantifies the change of coordinates of POIs
 *
 */
public class ChangeOfCordinates {
	
	static final Logger logger = Logger.getLogger(Log4jTest.class);
	
	/**
	 * @param oldPoiList : list of POIs from old quarter
	 * @param newPoiList : list of POIs from new quarter
	 * @return           : # of POIs which have no coordinates in the old quarter, 
	 *                     and remains in the new quarter but have coordinates
	 */
	public static int nGenerateCoords(List<Poi> oldPoiList, List<Poi> newPoiList){
		HashMap<String, Poi> newPoiMap = new HashMap<String, Poi>();
		for (Poi new_poi : newPoiList) {
			newPoiMap.put(new_poi.getId(), new_poi);
		}
		int cnt = 0;
		for(Poi old_poi : oldPoiList){
			if(!old_poi.hasCoord()){   // old POI has no coords
				Poi new_poi = newPoiMap.get(old_poi.getId());
				if(new_poi != null){   // and remains in the new quarter
					if(new_poi.hasCoord()){ // but get coordinates in the new quarter
						cnt ++;        
						System.out.println("old POI : "+ old_poi);
						System.out.println("new POI : "+ new_poi);
//						logger.info("old POI : "+ old_poi);
//						logger.info("new POI : "+ new_poi);
					}
				}
			}
			
		}
		return cnt;
	}
	
	/**
	 * @param oldPoiList : list of POIs from old quarter
	 * @param newPoiList : list of POIs from new quarter
	 * @return           : # of POIs which used to have coordinates in the old quarter 
	 *                     and remains in the new quarter but lose coordinates in new quarter
	 */
	public static int nLoseCoords(List<Poi> oldPoiList, List<Poi> newPoiList){
		HashMap<String, Poi> newPoiMap = new HashMap<String, Poi>();
		for (Poi new_poi : newPoiList) {
			newPoiMap.put(new_poi.getId(), new_poi);
		}
		int cnt = 0;
		for(Poi old_poi : oldPoiList){
			if(old_poi.hasCoord()){   // old POI has coords
				Poi new_poi = newPoiMap.get(old_poi.getId());
				if(new_poi != null){   // and remains in the new quarter
					if(!new_poi.hasCoord()){  // but lose coords in the new quarter
						cnt ++;       
						System.out.println("old POI : "+ old_poi);
						System.out.println("new POI : "+ new_poi);
//						logger.debug("old POI : "+ old_poi);
//						logger.debug("new POI : "+ new_poi);
					}
				}
			}
			
		}
		return cnt;
	}
	
	/**
	 * @param oldPoiList : list of POIs from old quarter
	 * @param newPoiList : list of POIs from new quarter
	 * @return           : a list of change of coords of old POI to new POI in terms of Euclidean distance
	 * 					   POI must be and have coords in both old POIs and new POIs
	 */
	public static List<Double> changeOfCoords(List<Poi> oldPoiList, List<Poi> newPoiList){
		List<Double> changes = new ArrayList<Double>();
		HashMap<String, Poi> newPoiMap = new HashMap<String, Poi>();
		for (Poi new_poi : newPoiList) {
			newPoiMap.put(new_poi.getId(), new_poi);
		}
		for(Poi old_poi : oldPoiList){
			if(old_poi.hasCoord()){   // old POI has coords
				Poi new_poi = newPoiMap.get(old_poi.getId());
				if(new_poi != null){   // and remains in the new quarter
					if(new_poi.hasCoord()){  // also have coords in the new quarter  
						if( old_poi.getLat() != new_poi.getLat() || old_poi.getLon() !=  new_poi.getLon()) {  // a change in coords
							System.out.println("old POI : "+ old_poi);
							System.out.println("new POI : "+ new_poi);
							changes.add(distance(old_poi.getLat(), old_poi.getLon(), new_poi.getLat(), new_poi.getLon()));
						}
					}
				}
			}
		}
		return changes;
	}
	
	/**
	 * @return the euclidean distance for point (lat1, lon1) and point (lat2, lon2)
	 */
	private static double distance(double lat1, double lon1, double lat2, double lon2){
		return Math.sqrt((lat1 - lat2) * (lat1 -lat2) + (lon1 - lon2) * (lon1 - lon2));
	}
	
	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		String old_poiFilePath = Config.getDataPath() + "TWN2011Q4\\rdf_poi\\" + 
			    "a__pre-production-namenode_services_navteq_productverification_rdf_raw_6554155_TWN2011Q4_CORE_ADAS_W5AM114M0WW5000QAACS_ALLFiles_corerdf_rdf_poi.txt";
		List<Poi> oldPoiList = PoiLoader.loadFromRdfFile(new File(old_poiFilePath));
		
		String new_poiFilePath = Config.getDataPath() + "TWN2012Q1\\rdf_poi.txt";
		List<Poi> newPoiList = PoiLoader.loadFromRdfFile(new File(new_poiFilePath));
		
		int n_gen_coords = nGenerateCoords(oldPoiList, newPoiList);
		System.err.println(" # of POIs get coordinates is : " + n_gen_coords);
		
		int n_lose_coords = nLoseCoords(oldPoiList, newPoiList);
		System.err.println(" # of POIs lose coordinates is : " + n_lose_coords);
		
		List<Double> changes = changeOfCoords(oldPoiList, newPoiList);
		//Collections.sort(changes);
		System.out.println(changes);
	}
	
	
}
