package com.trainbooking.microservice.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "TRAIN_STOPS")
@Table(name = "TRAIN_STOPS")
@NamedQuery(name = "TRAIN_STOPS.findAll", query = "SELECT v FROM TRAIN_STOPS v")
public class TrainStopsEntity{
	
	@Id
	@SequenceGenerator(name = "TRAIN_STOPS_ID_GENERATOR", sequenceName = "TRAIN_STOPS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAIN_STOPS_ID_GENERATOR")
	@Column(name = "TRAIN_STOP_ID")
	private Long trainStopId;
	@Column(name = "ARRIVAL")
	private Timestamp arriVal;
	@Column(name = "STATION_NAME")
	private String stationName;
	@Column(name = "DEPARTURE")
	private Timestamp departure;
	
	@ManyToOne
	@JoinColumn(name="ROUTE_ID")
	private Route route;
	
	@ManyToOne
	@JoinColumn(name = "TRAIN_ID")
	private TrainEntity train;

	public Long getTrainStopId() {
		return trainStopId;
	}

	public void setTrainStopId(Long trainStopId) {
		this.trainStopId = trainStopId;
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

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public TrainEntity getTrain() {
		return train;
	}

	public void setTrain(TrainEntity train) {
		this.train = train;
	}
	

}
