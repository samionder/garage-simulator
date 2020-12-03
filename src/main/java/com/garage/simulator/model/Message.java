package com.garage.simulator.model;

import java.util.List;

public class Message {

	private String command;
	private List<String> params;

	public Message(String command, List<String> params) {
		super();
		this.command = command;
		this.params = params;
	}

	public String getCommand() {
		return command;
	}

	public List<String> getParams() {
		return params;
	}

}
