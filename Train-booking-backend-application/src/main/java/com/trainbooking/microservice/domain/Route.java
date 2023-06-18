package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.sun.istack.NotNull;

public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 702991193389443657L;
	@javax.validation.constraints.NotNull(message = "This routeId is mandatory!")
	private Long routeId;
	//private Long trainId;
	private String source;
	private String destination;
	private Timestamp startDate;
	private String routeName;
	private Long duration;
	private List<TrainDomain> trainList;
//	public Long getTrainId() {
//		return trainId;
//	}
//	public void setTrainId(Long trainId) {
//		this.trainId = trainId;
//	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public List<TrainDomain> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<TrainDomain> trainList) {
		this.trainList = trainList;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
	

}
