package com.garage.simulator.command;

import com.garage.simulator.model.Message;
import com.garage.simulator.service.GarrageParkingService;


public class LeaveCommand extends Command {

  public LeaveCommand(GarrageParkingService garrageParkingService) {
    super(garrageParkingService);
  }


  @Override
  public void execute(Message command) {
	String ticket = command.getParams().get(0);
	garrageParkingService.leave(ticket);
  }
}
