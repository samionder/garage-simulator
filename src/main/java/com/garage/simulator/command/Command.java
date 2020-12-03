package com.garage.simulator.command;

import com.garage.simulator.model.Message;
import com.garage.simulator.service.GarrageParkingService;

public abstract class Command {
	protected GarrageParkingService garrageParkingService;

	public Command(GarrageParkingService garrageParkingService) {
		this.garrageParkingService = garrageParkingService;

	}

	public abstract void execute(Message command);
}
