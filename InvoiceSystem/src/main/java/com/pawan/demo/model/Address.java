package com.pawan.demo.model;

public class Address {

	private String state;
	private String city;
	private String address;
	private int postalCode;

	public Address(String state, String city, int postalCode) {
		super();
		this.state = state;
		this.city = city;
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", address=" + address + ", postalCode=" + postalCode
				+ "]";
	}

	public Address() {
		super();
	}

}
