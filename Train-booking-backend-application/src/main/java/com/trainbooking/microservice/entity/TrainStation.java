package com.trainbooking.microservice.entity;
//package com.infosys.tarinbooking.microservice.entities;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
///**
// * 
// * @author SOWMYA PEDDI
// *
// */
//@Entity(name = "TRAIN_STATION")
//@Table(name = "TRAIN_STATION")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "stationId", scope = Long.class)
//@NamedQuery(name = "TRAIN_STATION.findAll", query = "SELECT v FROM TRAIN_STATION v")
//public class TrainStation implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -9110884192919570333L;
//	@Id
//	@SequenceGenerator(name = "STATION_ID_GENERATOR", sequenceName = "STATION_ID_SEQ", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATION_ID_GENERATOR")
//	@Column(name = "STATION_ID")
//	private Long stationId;
//	@Column(name = "STATION_NAME")
//	private String stationName;
//	
//	@OneToMany(mappedBy="TRAIN_STOPS", cascade=CascadeType.ALL, orphanRemoval=true)
//	List<TrainStopsEntity> stops;
//
//	public Long getStationId() {
//		return stationId;
//	}
//
//	public void setStationId(Long stationId) {
//		this.stationId = stationId;
//	}
//
//	public String getStationName() {
//		return stationName;
//	}
//
//	public void setStationName(String stationName) {
//		this.stationName = stationName;
//	}
//
//	public List<TrainStopsEntity> getStops() {
//		return stops;
//	}
//
//	public void setStops(List<TrainStopsEntity> stops) {
//		this.stops = stops;
//	}
//
//	
//	
//
//	
//
//}
