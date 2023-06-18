package com.trainbooking.microservice.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "ROUTE")
@Table(name = "ROUTE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "routeId", scope = Long.class)
@NamedQuery(name = "ROUTE.findAll", query = "SELECT v FROM ROUTE v")
public class Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2733818496245461670L;
	@Id
	@SequenceGenerator(name = "ROUTE_ID_GENERATOR", sequenceName = "ROUTE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROUTE_ID_GENERATOR")
	@Column(name = "ROUTE_ID")
	private Long routeId;
	@Column(name = "ROUTE_NAME")
	private String routeName;
	@Column(name = "SOURCE")
	private String source;
	@Column(name = "DESTINATION")
	private String destination;
	@Column(name = "START_DATE")
	private Timestamp startDate;
	@Column(name = "DURATION")
	private Long duration;

	@OneToMany(mappedBy="route", cascade=CascadeType.ALL)
	private List<TrainEntity> trains;
	
	@OneToMany(mappedBy="route", cascade=CascadeType.ALL)
	private List<TicketEntity> ticketBooking;
	
	@OneToMany(mappedBy="route", cascade=CascadeType.ALL)
	private List<TrainStopsEntity> trainStops;
	

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
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

	public List<TrainEntity> getTrains() {
		return trains;
	}

	public void setTrains(List<TrainEntity> trains) {
		this.trains = trains;
	}

	public List<TicketEntity> getTicketBooking() {
		return ticketBooking;
	}

	public void setTicketBooking(List<TicketEntity> ticketBooking) {
		this.ticketBooking = ticketBooking;
	}

	public List<TrainStopsEntity> getTrainStops() {
		return trainStops;
	}

	public void setTrainStops(List<TrainStopsEntity> trainStops) {
		this.trainStops = trainStops;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}


}
