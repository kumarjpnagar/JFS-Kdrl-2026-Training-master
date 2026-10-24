package com.afs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmazonFeedbackController {

	
	@GetMapping("/feedback")
	public String getFeedback() {
		return "This is a Feedback Service";
	}
}
