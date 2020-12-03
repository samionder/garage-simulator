package com.garage.simulator.command;

import java.util.HashMap;
import java.util.Map;

import com.garage.simulator.constants.Constants;
import com.garage.simulator.service.GarrageParkingService;

public class CommandFactory {
	private Map<String, Command> commands = new HashMap<>();

	public CommandFactory(GarrageParkingService parkingService) {

		commands.put(Constants.PARK.toUpperCase(), new ParkCommand(parkingService));

		commands.put(Constants.LEAVE.toUpperCase(), new LeaveCommand(parkingService));

		commands.put(Constants.STATUS.toUpperCase(), new StatusCommand(parkingService));
	}

	public Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		
		if (command == null) {
			System.out.println("Command Not Found");
		}
		return command;
	}
}
