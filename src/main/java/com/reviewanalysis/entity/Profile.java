package com.reviewanalysis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "profile")

public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;
	private String firstName;
	// private String userName;
	private String lastName;
	private String address;
	private Long phoneNumber;
	private String emailId;

	
	public Profile() 
	{
		super();
	}

	public Profile(String firstName, String lastName, String address, Long phoneNumber, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	// @OneToOne(cascade = CascadeType.ALL, optional = false)
		// @JoinColumn(name = "user")
		// private User user;


}
