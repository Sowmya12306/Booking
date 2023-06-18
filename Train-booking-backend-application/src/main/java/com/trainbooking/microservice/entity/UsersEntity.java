package com.trainbooking.microservice.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author SOWMYA PEDDI
 *
 */
@Entity(name = "USERS")
@Table(name = "USERS")
@NamedQuery(name = "USERS.findAll", query = "SELECT v FROM USERS v")
public class UsersEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7226593159803290138L;
	@Id
	@SequenceGenerator(name = "USERS_ID_GENERATOR", sequenceName = "USERS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ID_GENERATOR")
	@Column(name = "USER_ID")
	private Long userId;	
	@Column(name = "DOB")
	private Timestamp dob;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "PASSWORD")
	private String passWord;
	@Column(name = "EMAIL")
	private String emailId;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	@Column(name = "USER_ROLE")
	private String userRole;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<TicketEntity> ticketBooking;
	
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
	public List<TicketEntity> getTicketBooking() {
		return ticketBooking;
	}
	public void setTicketBooking(List<TicketEntity> ticketBooking) {
		this.ticketBooking = ticketBooking;
	}

	
}
