package com.workerapp.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity

public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long workerId;   
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
    private String  skillType;
    @NotNull
    private Integer yearsOfExperience ;     
    @NotNull
    private String address ;
    @Lob
    private byte[] image  ;
	
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Worker(Long workerId, String firstName, String lastName, String email, String password,
			String reTypePassword, String phoneNumber, Date registerDate, String skillType, Integer yearsOfExperience,
			String address, byte[] image) {
		super();
		this.workerId = workerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.reTypePassword = reTypePassword;
		this.phoneNumber = phoneNumber;
		this.registerDate = registerDate;
		this.skillType = skillType;
		this.yearsOfExperience = yearsOfExperience;
		this.address = address;
		this.image = image;
	}

	public Long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
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

	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


    
    

}
