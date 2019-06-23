package com.pawan.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	private int cId;
	private String cAddress;
	private int cAge;
	private String cName;
	private String cPassword;
	private Long cPhoneNum;

	public Customer() {

	}

	public Customer(int cId, String cName, int cAge, Long cPhoneNum, String cAddress, String password) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cAge = cAge;
		this.cPhoneNum = cPhoneNum;
		this.cAddress = cAddress;
		this.cPassword = password;
	}

	public String getPassword() {
		return cPassword;
	}

	public void setPassword(String password) {
		this.cPassword = password;
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

	public int getcAge() {
		return cAge;
	}

	public void setcAge(int cAge) {
		this.cAge = cAge;
	}

	public Long getcPhoneNum() {
		return cPhoneNum;
	}

	public void setcPhoneNum(Long cPhoneNum) {
		this.cPhoneNum = cPhoneNum;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cName=" + cName + ", cAge=" + cAge + ", cPhoneNum=" + cPhoneNum
				+ ", cAddress=" + cAddress + "]";
	}

}
