package com.garage.simulator.model;

public class Slot {
	private Vehicle vehicle;
	private int slotNumber;
	private Status status;

	public Slot(Status status, int number) {
		this.status = status;
		this.slotNumber = number;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public void cleanSlot(int slotNumber) {
		this.vehicle = null;
		this.status = Status.FREE;
		this.slotNumber = slotNumber;
	}
	
	public void fill(Vehicle vehicle, Status status) {
		this.vehicle = vehicle;
		this.status = status;
	}
	
	public boolean isAllocated() {
		return status==Status.ALLOCATED;
	}
	
	public boolean isNotEmpty() {
		return status != Status.FREE;
	}
	
}
