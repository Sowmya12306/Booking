package com.trainbooking.microservice.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.Data;

@Entity(name = "TICKET_BOOKING")
@Table(name = "TICKET_BOOKING")
@NamedQuery(name = "TICKET_BOOKING.findAll", query = "SELECT v FROM TICKET_BOOKING v")
public class TicketEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -432417281129642403L;
	@Id
	@SequenceGenerator(name = "TICKET_BOOKING_ID_GENERATOR", sequenceName = "TICKET_BOOKING_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_BOOKING_ID_GENERATOR")
	@Column(name = "TICKET_ID")
	private Long ticketId;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "SOURCE")
	private String source;
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "TRAIN_NUMBER")
	private String trainNumber;
	
	@ManyToOne
	@JoinColumn(name="ROUTE_ID")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UsersEntity user;

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

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}	
	
	
}
