package com.example.ContactInfo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContactInfo {
	@Id
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String status;
	
//	public ContactInfo(String firstName, String lastName, String email, long phoneNumber, String status) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//		this.status = status;
//	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
