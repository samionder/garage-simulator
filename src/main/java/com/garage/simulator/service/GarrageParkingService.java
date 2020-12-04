package com.garage.simulator.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.garage.simulator.model.Garage;
import com.garage.simulator.model.OutputMessage;
import com.garage.simulator.model.Slot;
import com.garage.simulator.model.Vehicle;

public class GarrageParkingService {
	private Garage garage;

	public GarrageParkingService(Garage garage) {
		this.garage = garage;
	}

	public void park(Vehicle vehicle) {
		boolean isParked = garage.park(vehicle);
		if(isParked) {
			System.out.println("Allocated " + vehicle.getSize() + " slot");
			OutputMessage s = new OutputMessage();
			s.addMessage("Allocated " + vehicle.getSize() + " slot");
		}else {
			System.out.println("No Enoug Space");
			new OutputMessage().addMessage("No Enoug Space");
		}
	}

	public void leave(String id) {
		int discardedSlot = garage.leave(id);
		System.out.println("Cleaned " + discardedSlot + " slot");
	}

	public void status() {
		List<Slot> allocatedSlots = garage.getAllocatedSlots();

		System.out.println("Status:");
		if (allocatedSlots.isEmpty()) {
			System.out.println("Garage Is Empty");
		}

		Map<Vehicle, List<Integer>> collect = allocatedSlots.stream().collect(
				Collectors.groupingBy(Slot::getVehicle, Collectors.mapping(Slot::getSlotNumber, Collectors.toList())));

		collect.entrySet().forEach(item -> {
			Vehicle vehicle = item.getKey();
			List<Integer> slots = item.getValue();
			System.out.println(vehicle.getRegistrationNumber() + " " + vehicle.getColor() + " " + slots);
		});

	}

}
