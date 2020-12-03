package com.garage.simulator.model;

import java.util.List;

public interface Garage {

	public boolean park(Vehicle vehicle);

	public int leave(String vehicleId);

	public List<Slot> getAvailableSlots(int requiredSpace);

	public List<Slot> getAllocatedSlots();

}
