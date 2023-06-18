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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * 
 * @author SOWMYA PEDDI
 *
 */
@Entity(name = "TRAIN")
@Table(name = "TRAIN")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "trainNumber", scope = Long.class)
@NamedQuery(name = "TRAIN.findAll", query = "SELECT v FROM TRAIN v")
public class TrainEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8887793175173349532L;
	@Id
	@SequenceGenerator(name = "TRAIN_ID_GENERATOR", sequenceName = "TRAIN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAIN_ID_GENERATOR")
	@Column(name = "TRAIN_ID")
	private Long trainId;
	@Column(name = "TRAIN_NAME")
	private String trainName;
	@Column(name = "TRAIN_NUMBER")
	private Long trainNumber;
	
	@ManyToOne
	@JoinColumn(name = "ROUTE_ID")
	private Route route;
	
	@OneToMany(mappedBy="train", cascade=CascadeType.ALL)
	private List<TrainStopsEntity> trainStops;

	public Long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
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

	public List<TrainStopsEntity> getTrainStops() {
		return trainStops;
	}

	public void setTrainStops(List<TrainStopsEntity> trainStops) {
		this.trainStops = trainStops;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	
	

}
