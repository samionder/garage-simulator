package com.garage.simulator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleLineGarage implements Garage {
	private List<Slot> slots = new ArrayList<>();
	private Map<Integer, Vehicle> vehicles;



	public SingleLineGarage() {
		this.vehicles = new HashMap<>();
		IntStream.range(0, 10).forEach(t->slots.add(new Slot(Status.FREE, t)));
	}



	@Override
	public boolean park(Vehicle vehicle) {
		List<Slot> availableSlots = getAvailableSlots(vehicle.getSize());
		if (!availableSlots.isEmpty()) {
			availableSlots.forEach(slot -> {
				slot.assignCar(vehicle);
				slot.setStatus(Status.ALLOCATED);
			});
			
			vehicles.put(vehicles.size() + 1, vehicle);
			return true;
		}
		return false;

	}

	@Override
	public int leave(String ticket) {
		int ticketID = Integer.parseInt(ticket);
		Vehicle vehicle = vehicles.get(ticketID);
		
		List<Slot> allocatedSlot = slots.stream()
			.filter(Slot::isAllocated)
			.filter(slot -> slot.getVehicle().getRegistrationNumber().equals(vehicle.getRegistrationNumber()))
			.collect(Collectors.toList());
		
	
			allocatedSlot.forEach(slot ->{
				slot.cleanSlot(slot.getSlotNumber());
			});
			
			vehicles.remove(ticketID);
			
			return allocatedSlot.size();
	}
	
	
	@Override
	public List<Slot> getAvailableSlots(int requiredSpace) {
		List<Slot> availbleSlots = new ArrayList<>();

		for (Slot slot : slots) {
			if (slot.getStatus() == Status.FREE) {
				availbleSlots.add(slot);
				if (availbleSlots.size() == requiredSpace)
					return availbleSlots;
			} else {
				availbleSlots = new ArrayList<>();
			}
		}
		return Collections.emptyList();
	}



	@Override
	public List<Slot> getAllocatedSlots() {
		return slots.stream()
				.filter(Slot::isAllocated)
				.collect(Collectors.toList());
	}
	
	
	


}
