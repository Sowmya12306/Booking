package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class TicketBookingRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5876754896239689511L;
	private Long userId;
	private Long ticketId;
	private Long trainNumber;
	private Date date;
	private String source;
	private String destination;
	private Route route;
	private Long routeId;
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
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public Long getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
	}
	
	
}
