package com.cg.bookStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "bookstore_customer")
public class CustomerInformation {
	
	@Column(name="customer_id")
	private long customerId;
	
	@Id
	@Column(name = "email")
	@Size(min=10, max=64)
	private String email;

	@Column(name = "full_name")
	@Size(min=1, max=30)
	private String fullName;

	@Column(name = "password")
	@Size(min=8, max=16)
	private String password;

	@Column(name = "phone_no")
	@Size(min=10, max=15)
	private String phoneNumber;

	@Column(name = "address")
	@Size(min=10, max=128)
	private String address;
	
	@Column(name = "city")
	@Size(min=3, max=32)
	private String city;

	@Column(name = "pin_code")
	private String pinCode;

	@Column(name = "country")
	@Size(min=3, max=64)
	private String country;
	
	@Column(name="register_date")
	private String registerDate;

	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public CustomerInformation() {
		super();
	}

	public CustomerInformation(int customerId, @Size(min = 10, max = 64) String email,
			@Size(min = 1, max = 30) String fullName, @Size(min = 8, max = 16) String password,
			@Size(min = 10, max = 15) @Size(min = 10, max = 15) String phoneNumber, @Size(min = 10, max = 128) String address,
			@Size(min = 3, max = 32) String city, @Size(min = 3, max = 24) String pinCode,
			@Size(min = 3, max = 64) String country, String registerDate) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.country = country;
		this.registerDate = registerDate;
	}

	
	
	
	
	
	
}