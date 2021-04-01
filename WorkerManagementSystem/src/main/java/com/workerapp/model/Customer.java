package com.workerapp.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.sun.istack.NotNull;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	  private Date registerDate = Calendar.getInstance().getTime();     
    @NotNull
    private String customerAddress ;
    @Lob
    private byte[] image  ;
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
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Customer(Long customerId, String firstName, String lastName, String email, String password,
			String reTypePassword, String phoneNumber, Date registerDate, String customerAddress, byte[] image) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.reTypePassword = reTypePassword;
		this.phoneNumber = phoneNumber;
		this.registerDate = registerDate;
		this.customerAddress = customerAddress;
		this.image = image;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	
}
