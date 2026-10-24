package com.rba.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class SampleController {
	
	@GetMapping("/sample")
	//@ResponseBody
	public String getSample() {
		return "This is a Sampe Response";
	}

}
