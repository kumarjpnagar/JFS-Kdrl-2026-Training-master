package com.rba.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rba.demo.model.Room;

@Controller
@RequestMapping("/rbc")
public class RoomBookingController {

	//RequestHandler Methods
	//GET,POST,PUT,DELETE
	//doGet(),doPost()
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	//@GetMapping("/welcome")
	//@PostMapping
	//@PutMapping
	//@DeleteMapping
	@ResponseBody
	//Annotation that indicates a method return value 
			//should be bound to the webresponse body
	public String welcome() {
		return "Welcome To Room Booking!";
	}
	
	@GetMapping
	@ResponseBody
	public Room getRoom() {
		return new Room(101,"TLS Auditorium",80);
	}
}