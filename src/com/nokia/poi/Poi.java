package com.nokia.poi;

/**
 * 
 * @author huayili
 * 
 * this Poi is the class storing basic information about a POI
 * corresponding to the POIs in RDF_POI
 */
public class Poi {
	private String id;
	private double lat = -200; //default value for missing lat
	private double lon = -200; //default value for missing lon
	
	
	Poi(){}
	Poi(String id){this.setId(id);}
	Poi(String id, double lat, double lon){
		this(id);
		this.setLat(lat);
		this.setLon(lon);
	}
	
	public boolean equals(Poi other){
		return id.equals(other.id);
	}
	
	public int hashCode(){
		return id.hashCode();
	}
	
	@Override
	public String toString() {
		return "Poi [id=" + id + ", lat=" + lat + ", lon=" + lon + "]";
	}
	
	/**
	 * some POIs may not have coordinates, the POIs with no coordinates 
	 * are assigned with lat = - 200 and lon -200
	 * @return : whether a POI has a coordinate
	 */
	public boolean hasCoord(){
		return ! (lat < -180 || lon < -180); 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	
}
