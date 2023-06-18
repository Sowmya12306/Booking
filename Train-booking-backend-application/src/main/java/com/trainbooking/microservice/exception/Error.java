/**
 * 
 */
package com.trainbooking.microservice.exception;

import java.io.Serializable;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class Error implements Serializable {

	private static final long serialVersionUID = -8181452491997758872L;
	private String code;
	private String description;

	/**
	 * @param code
	 * @param description
	 */
	public Error(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
