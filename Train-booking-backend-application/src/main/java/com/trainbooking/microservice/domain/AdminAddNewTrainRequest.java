package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;



public class AdminAddNewTrainRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5858932531768659489L;
	//@NotNull(message = "id is mandatory")
	private Long trainId;
	//@NotNull(message = "trainName is mandatory")
	private String trainName;	
	private Long userId;
	private Route route;
	private Station station;
	private List<Stop> stop;
	public Long getTrainId() {
		return trainId;
	}
	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<Stop> getStop() {
		return stop;
	}
	public void setStop(List<Stop> stop) {
		this.stop = stop;
	}
	
	
	
}
