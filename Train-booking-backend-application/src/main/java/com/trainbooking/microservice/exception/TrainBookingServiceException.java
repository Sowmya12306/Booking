/**
 * 
 */
package com.trainbooking.microservice.exception;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class TrainBookingServiceException extends RuntimeException {

	private static final long serialVersionUID = 4790307354094602555L;

	public TrainBookingServiceException(String requestIdentifier, String errorMessage) {
		this.requestIdentifier = requestIdentifier;
		this.errorMessage = errorMessage;
	}

	private String requestIdentifier;
	private String errorMessage;

	public String getRequestIdentifier() {
		return requestIdentifier;
	}

	public void setRequestIdentifier(String requestIdentifier) {
		this.requestIdentifier = requestIdentifier;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
