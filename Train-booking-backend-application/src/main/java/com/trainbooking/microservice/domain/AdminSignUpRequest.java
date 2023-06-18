package com.trainbooking.microservice.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author SOWMYA PEDDI
 *
 */
public class AdminSignUpRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3735628868423251995L;
	private Long userId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp dob;
	@NotNull(message = "FirstName is mandatory")
	private String firstName;
	private String lastName;
	private String passWord;
	@NotNull(message = "emial Id is mandatory")
	private String emailId;
	private String gender;
	private String type;
	private Long phoneNumber;
	private String userRole;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Timestamp getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	

}
