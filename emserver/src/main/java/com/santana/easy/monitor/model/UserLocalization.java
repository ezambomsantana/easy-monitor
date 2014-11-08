package com.santana.easy.monitor.model;

import java.io.Serializable;
import java.util.Date;

public class UserLocalization implements Serializable {
	
	private static final long serialVersionUID = -3842844978617110554L;
	
	private String id;
	private String lat;
	private String lon;
	private Date dateLocalization;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public Date getDateLocalization() {
		return dateLocalization;
	}
	public void setDateLocalization(Date dateLocalization) {
		this.dateLocalization = dateLocalization;
	}
		
}
