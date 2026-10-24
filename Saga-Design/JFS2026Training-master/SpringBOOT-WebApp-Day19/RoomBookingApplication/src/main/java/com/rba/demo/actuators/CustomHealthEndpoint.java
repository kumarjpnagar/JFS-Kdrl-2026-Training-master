package com.rba.demo.actuators;

import java.util.HashMap;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

//Make this call available for IoC
//This Custom Endpoint should be made available only for
//Administrator
@Component
@Endpoint(id = "database-healthcheck")
public class CustomHealthEndpoint {

	@ReadOperation //(@GetMapping in the controller)
	public HashMap<String, String> health(){
		
		HashMap<String, String> details = new HashMap<>();
		//To Evaluate the Health of Your Applciation
		//in a custom check
		details.put("DatabaseHealthStatus","Database is Up and Running BALAJI!..");
		
		return details;
	}
	
	@ReadOperation
	public String customReadMethod(@Selector String name) {
		return "This is Custom End-Point Read Operation+Balaji"+name;
	}
	
	@WriteOperation //POST (@PostMapping)
	public void writeEndpoint(@Selector String data) {
		System.out.println("Write Data"+data);
	}
	
	@DeleteOperation //Delete (@DeleteMapping)
	public void deleteEndpoint(@Selector String deleteData) {
		System.out.println("Delete Operation Triggered"+deleteData);
	}
}
