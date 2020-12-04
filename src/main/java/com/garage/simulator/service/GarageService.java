package com.garage.simulator.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.garage.simulator.command.Command;
import com.garage.simulator.command.CommandFactory;
import com.garage.simulator.model.Message;
import com.garage.simulator.model.SingleLineGarage;

@Service
public class GarageService {

	private GarrageParkingService parkingService;
	private CommandFactory commandFactory;

	public GarageService() {
		this.parkingService = new GarrageParkingService(new SingleLineGarage());
		this.commandFactory = new CommandFactory(parkingService);
	}

	public void apply(String commandText) {

		Message message = createMessage(commandText);
		Command command = commandFactory.getCommand(message.getCommand());
		command.execute(message);

	}

	private Message createMessage(String commandText) {

		StringUtils.split(commandText);

		final List<String> commandList = Stream.of(StringUtils.split(commandText)).collect(Collectors.toList());

		String name = commandList.get(0).toUpperCase();
		List<String> params = commandList.stream().skip(1).collect(Collectors.toList());

		return new Message(name, params);

	}
	
	public void test() {
		System.out.println("TEST SERVICE");
		String input1 = "park 34-SO-1988 Black Car";
		String input2 = "park 34-BO-1987 Red Truck";
		String input3 = "park 34-VO-2018 Blue Jeep";
		String input4 = "park 34-HBO-2020 Black Truck";

		String input5 = "status";
		String input6 = "leave 3";
		
		String input7= "park 34-LO-2000 White Car";
		

		apply(input1);
		apply(input2);
		apply(input3);
		apply(input4);
		apply(input5);
		apply(input6);

	}
	
	public static void main(String[] args) {
		GarageService s = new GarageService();
		s.test();
	}

}
