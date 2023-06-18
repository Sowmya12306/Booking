/**
 * 
 */
package com.trainbooking.microservice.exception;

import java.util.List;

import lombok.ToString;

/**
 * 
 * SOWMYA PEDDI
 *
 */
@ToString
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -8777365194348283479L;

	private String requestIdentifier;
	private String errorMessage;
	private List<Error> errors;

	/**
	 * @param requestIdentifier
	 * @param errorMessage
	 * @param errors
	 */
	public BaseException(String requestIdentifier, String errorMessage, List<Error> errors) {
		this.requestIdentifier = requestIdentifier;
		this.errorMessage = errorMessage;
		this.errors = errors;
	}

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

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	

}
