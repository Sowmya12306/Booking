package com.trainbooking.microservice.domain;

import java.io.Serializable;

public class Station implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8241610503655639049L;
	private Long stationId;
	private String stationName;
	private Stop stop;
	public Long getStationId() {
		return stationId;
	}
	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Stop getStop() {
		return stop;
	}
	public void setStop(Stop stop) {
		this.stop = stop;
	}
	
	

}
