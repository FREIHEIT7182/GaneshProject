package com.workerapp.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity

public class Customer {
	@Id
	private Long customerId;   
	@NotNull
    private String firstName;  
	@NotNull
    private String lastName;   
	
	@Column(unique=true)
    private String email ; 
	@Column(unique=true)
    private String password;   
	@Column(unique=true)
    private String reTypePassword  ; 
	@Column(unique=true,length = 10)
    private String phoneNumber ;                            
    private Date registerDate ;
    @NotNull
    private String  workType;
     
    @NotNull
    private String workerAddress ;
    @Lob
    private byte[] image  ;
	public Customer(Long customerId, String firstName, String lastName, String email, String password,
			String reTypePassword, String phoneNumber, Date registerDate, String workType, String workerAddress,
			byte[] image) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.reTypePassword = reTypePassword;
		this.phoneNumber = phoneNumber;
		this.registerDate = registerDate;
		this.workType = workType;
		this.workerAddress = workerAddress;
		this.image = image;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReTypePassword() {
		return reTypePassword;
	}
	public void setReTypePassword(String reTypePassword) {
		this.reTypePassword = reTypePassword;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public String getWorkerAddress() {
		return workerAddress;
	}
	public void setWorkerAddress(String workerAddress) {
		this.workerAddress = workerAddress;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", reTypePassword=" + reTypePassword + ", phoneNumber="
				+ phoneNumber + ", registerDate=" + registerDate + ", workType=" + workType + ", workerAddress="
				+ workerAddress + ", image=" + Arrays.toString(image) + "]";
	}
	

	
}
