package com.garage.simulator.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

public class OutputMessage {

	private List<String> messages;
	

	public OutputMessage addMessage(String message) {
		if(ObjectUtils.isEmpty(messages))
			messages = new ArrayList<>();
		
		messages.add(message);
		
		return this;
	}


	
	
}
