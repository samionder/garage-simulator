package com.garage.simulator.command;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.garage.simulator.constants.Constants;
import com.garage.simulator.model.Car;
import com.garage.simulator.model.Jeep;
import com.garage.simulator.model.Truck;
import com.garage.simulator.model.Vehicle;

public class VehicleFactory {

	public Optional<Vehicle> createVehicle(List<String> params) {

		if (!params.isEmpty() && params.size() == 3) {
			String type = params.get(2);

			if (StringUtils.equalsIgnoreCase(type, Constants.CAR))
				return Optional.of(new Car(params.get(0), params.get(1)));
			else if (StringUtils.equalsIgnoreCase(type, Constants.TRUCK))
				return Optional.of(new Truck(params.get(0), params.get(1)));
			else if (StringUtils.equalsIgnoreCase(type, Constants.JEEP))
				return Optional.of(new Jeep(params.get(0), params.get(1)));
		}

		return Optional.empty();

	}

}
