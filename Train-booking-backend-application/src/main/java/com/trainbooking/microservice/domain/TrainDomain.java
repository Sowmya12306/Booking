package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class TrainDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8559218873557844520L;
	private Long trainId;
	private Long trainNumber;
	private String trainName;
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
	public Long getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
	}
	public List<Stop> getStop() {
		return stop;
	}
	public void setStop(List<Stop> stop) {
		this.stop = stop;
	}

	

}
