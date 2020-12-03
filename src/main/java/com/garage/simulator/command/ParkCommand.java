package com.garage.simulator.command;

import java.util.Optional;

import com.garage.simulator.model.Message;
import com.garage.simulator.model.Vehicle;
import com.garage.simulator.service.GarrageParkingService;

public class ParkCommand extends Command {
	private VehicleFactory vehicleFactory;

	public ParkCommand(GarrageParkingService garrageParkingService) {
		super(garrageParkingService);
		this.vehicleFactory = new VehicleFactory();
	}

	@Override
	public void execute(Message command) {
		Optional<Vehicle> vehicle = vehicleFactory.createVehicle(command.getParams());
		vehicle.ifPresent(v -> garrageParkingService.park(v));
	}

}
