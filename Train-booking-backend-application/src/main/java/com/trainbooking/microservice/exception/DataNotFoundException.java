/**
 * 
 */
package com.trainbooking.microservice.exception;

import java.util.List;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class DataNotFoundException extends BaseException {

	private static final long serialVersionUID = 2360528921721799539L;

	/**
	 * @param requestIdentifier
	 * @param errorMessage
	 * @param errors
	 */
	public DataNotFoundException(String requestIdentifier, String errorMessage, List<Error> errors) {
		super(requestIdentifier, errorMessage, errors);
	}

}
