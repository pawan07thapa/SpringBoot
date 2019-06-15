package com.pawan.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component  // creates a object gives it to getBean
// @Scope(value="prototype")
public class Alien {

	private String aname;
	private int aid;
	private String tech;
	
	@Autowired
	@Qualifier("lap")
	private laptop lap;

	public Alien() {
		System.out.println("Object Created");
	}
	
	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public laptop getLap() {
		return lap;
	}

	public void setLap(laptop lap) {
		this.lap = lap;
	}

	
	@Override
	public String toString() {
		return "Alien [aname=" + aname + ", aid=" + aid + ", tech=" + tech + ", lap=" + lap + "]";
	}

}
