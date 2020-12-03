package com.garage.simulator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.garage.simulator.command.VehicleFactory;
import com.garage.simulator.model.Car;
import com.garage.simulator.model.Vehicle;

public class VehicleFactoryTest {
	
    VehicleFactory vehicleFactory;
    
    @Before
    public void init() {
    	vehicleFactory = new VehicleFactory();
    }
	
	@Test
	public void doNotCreateVehicleIfParamIsEmpty(){
		
		List<String> params = new ArrayList<>();
		Optional<Vehicle> createVehicle = vehicleFactory.createVehicle(params);
		assertFalse(createVehicle.isPresent());
		
	}
	
	
	@Test
	public void doNotCreateVehicleIfParamSizeNotThree(){
		
		List<String> params = new ArrayList<>();
		params.add("AAAAA");
		params.add("BBBBB");
		Optional<Vehicle> createVehicle = vehicleFactory.createVehicle(params);
		assertFalse(createVehicle.isPresent());
		
	}
	
	@Test
	public void doNotCreateVehicleIfParamTypeNotMatch(){
		
		List<String> params = new ArrayList<>();
		params.add("AAAAA");
		params.add("BBBBB");
		params.add("CCCCC");
		Optional<Vehicle> createVehicle = vehicleFactory.createVehicle(params);
		assertFalse(createVehicle.isPresent());
		
	}
	
	@Test
	public void createCarIfParamsSmooth(){
		
		List<String> params = new ArrayList<>();
		params.add("34-LO-2000");
		params.add("White");
		params.add("Car");
		Optional<Vehicle> createVehicle = vehicleFactory.createVehicle(params);
		
		assertTrue(createVehicle.get() instanceof Car);
		
	}
	

}
