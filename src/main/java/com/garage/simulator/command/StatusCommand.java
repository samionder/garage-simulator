package com.garage.simulator.command;

import com.garage.simulator.model.Message;
import com.garage.simulator.service.GarrageParkingService;

public class StatusCommand extends Command {

	public StatusCommand(GarrageParkingService garrageParkingService) {
		super(garrageParkingService);
	}

	@Override
	public void execute(Message command) {
		garrageParkingService.status();

	}

}
