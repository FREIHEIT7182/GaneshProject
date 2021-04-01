package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cognizant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cId;
	@Column(name= "cname")
	private String cName;
	@Column(name = "dept")
	private String dept;
	public Cognizant(int cId, String cName, String dept) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.dept = dept;
	}
	public Cognizant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
