package com.rms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MaintainanceController {

	//SpeL Template
	@Value("${roombookingtiming}")
	String bookingTiming;
	
	@GetMapping
	public String getTimingDetails() {
		
		return "The Booking Time Is: " + bookingTiming;  
	}
}
