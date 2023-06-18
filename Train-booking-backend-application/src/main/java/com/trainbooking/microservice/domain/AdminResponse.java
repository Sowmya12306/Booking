package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.util.List;

import com.trainbooking.microservice.exception.Errors;

public class AdminResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1335967468439771776L;
	private String requestIdentifier;
	private String transactionDate;
	private boolean success;
	private Errors errors;
	private String message;
	private List<TrainDomain> trainDetails;
	private List<TicketBookingDomain> userDomain;
	private List<Route> route;
	public String getRequestIdentifier() {
		return requestIdentifier;
	}
	public void setRequestIdentifier(String requestIdentifier) {
		this.requestIdentifier = requestIdentifier;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Errors getErrors() {
		return errors;
	}
	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<TrainDomain> getTrainDetails() {
		return trainDetails;
	}
	public void setTrainDetails(List<TrainDomain> trainDetails) {
		this.trainDetails = trainDetails;
	}
	public List<TicketBookingDomain> getUserDomain() {
		return userDomain;
	}
	public void setUserDomain(List<TicketBookingDomain> userDomain) {
		this.userDomain = userDomain;
	}
	public List<Route> getRoute() {
		return route;
	}
	public void setRoute(List<Route> route) {
		this.route = route;
	}
	
	
	
	
	
}
