package com.example.basiccrud.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {
	
	private int id;
	private String name;
	
	@JsonProperty("date-of-birth")
	private LocalDate dob;
	
	@JsonProperty("mobile-number")
	private String mobileNumber;
	
	public User(int id, String name, LocalDate dob, String mobileNumber) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
}
