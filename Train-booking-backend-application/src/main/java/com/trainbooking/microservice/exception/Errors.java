/**
 * 
 */
package com.trainbooking.microservice.exception;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class Errors implements Serializable {

	private static final long serialVersionUID = 8948013815336935851L;

	private String errorMessage;
	private List<Error> exceptionResponse;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Error> getExceptionResponse() {
		return exceptionResponse;
	}

	public void setExceptionResponse(List<Error> exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}
}
