package com.nokia.poi;

public class Poi {
	private String id;
	private float lat = -200; //default value for missing lat
	private float lon = -200; //default value for missing lon
	
	
	Poi(){}
	Poi(String id){this.setId(id);}
	Poi(String id, float lat, float lon){
		this(id);
		this.setLat(lat);
		this.setLon(lon);
	}
	
	@Override
	public String toString() {
		return "Poi [id=" + id + ", lat=" + lat + ", lon=" + lon + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	
}
