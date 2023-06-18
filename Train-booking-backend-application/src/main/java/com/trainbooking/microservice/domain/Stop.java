package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Stop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5863696304938201134L;
	private Long stopId;
	private String stationName;
	private Timestamp arriVal;
	private Timestamp departure;
	public Long getStopId() {
		return stopId;
	}
	public void setStopId(Long stopId) {
		this.stopId = stopId;
	}
	public Timestamp getArriVal() {
		return arriVal;
	}
	public void setArriVal(Timestamp arriVal) {
		this.arriVal = arriVal;
	}
	public Timestamp getDeparture() {
		return departure;
	}
	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	

}
