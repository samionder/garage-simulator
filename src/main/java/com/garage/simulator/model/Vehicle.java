package com.garage.simulator.model;

public abstract class Vehicle {

	protected String color;
	protected int size;
	protected String registrationNumber;

	public int getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
