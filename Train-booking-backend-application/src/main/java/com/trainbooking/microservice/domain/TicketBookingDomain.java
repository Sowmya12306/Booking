package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.sql.Date;

public class TicketBookingDomain implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -3529312808619836979L;
	private Long ticketId;
	private Date date;
	private String toLocation;
	private String fromLocation;	
	private String TrainNumber;
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getTrainNumber() {
		return TrainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		TrainNumber = trainNumber;
	}
	
	
	
	
}
