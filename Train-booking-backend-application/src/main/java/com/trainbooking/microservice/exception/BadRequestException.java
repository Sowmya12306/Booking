/**
 * 
 */
package com.trainbooking.microservice.exception;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class BadRequestException extends BaseException {

	private static final long serialVersionUID = -1917120066702093318L;

	/**
	 * @param requestIdentifier
	 * @param errorMessage
	 * @param errors
	 */
	public BadRequestException(String requestIdentifier, String errorMessage, List<Error> errors) {
		super(requestIdentifier, errorMessage, errors);
		
	}
	
}
