package com.trainbooking.microservice.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class TrainStopsDomain implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 3821152497220628307L;
	private Long id;
	private String stop1;
	private String stop2;
	private String stop3;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStop1() {
		return stop1;
	}
	public void setStop1(String stop1) {
		this.stop1 = stop1;
	}
	public String getStop2() {
		return stop2;
	}
	public void setStop2(String stop2) {
		this.stop2 = stop2;
	}
	public String getStop3() {
		return stop3;
	}
	public void setStop3(String stop3) {
		this.stop3 = stop3;
	}

}
