package com.pawan.demo;

import org.springframework.stereotype.Component;

@Component("lap")
public class laptop {
	private int lid;
	private String lbrand;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLbrand() {
		return lbrand;
	}

	public void setLbrand(String lbrand) {
		this.lbrand = lbrand;
	}

	@Override
	public String toString() {
		return "laptop [lid=" + lid + ", lbrand=" + lbrand + "]";
	}

	public void compile() {
		System.out.println("Compiling");
	}

}