package com.garage.simulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.garage.simulator.constants.Constants;
import com.garage.simulator.model.CommandText;
import com.garage.simulator.service.GarageService;

@RestController
@RequestMapping("api/garage/simulator")
public class GarageController {

	@Autowired
	private GarageService garageService;

	@PostMapping("/park")
	public @ResponseBody String park(@RequestBody CommandText commandText) {
		garageService.apply(Constants.PARK + " " + commandText.getMessage());
		return "";
	}

	@PostMapping("/leave")
	public @ResponseBody String leave(@RequestBody CommandText commandText) {
		garageService.apply(Constants.LEAVE + " " + commandText.getMessage());
		return "";
	}

	@GetMapping("/status")
	public @ResponseBody String status() {
		garageService.apply(Constants.STATUS);
		return "";
	}

	@PostMapping("/run")
	public @ResponseBody String runCommand(@RequestBody CommandText commandText) {
		garageService.apply(commandText.getMessage());
		return "";
	}

}
