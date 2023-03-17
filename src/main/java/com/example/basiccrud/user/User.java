package com.example.basiccrud.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="user_details") 
public class User {  //user is keyword in h2
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
   @JsonProperty("date-of-birth")
	private LocalDate dateofbirth;
	
   @JsonProperty("mobile-number")
	private String mobileNumber;
   
   public User() {
	   
   }
	
	public User(int id, String name, LocalDate dob, String mobileNumber) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dob;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dateofbirth;
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
		this.dateofbirth = dob;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateofbirth=" + dateofbirth + ", mobileNumber=" + mobileNumber
				+ "]";
	}

	
}
