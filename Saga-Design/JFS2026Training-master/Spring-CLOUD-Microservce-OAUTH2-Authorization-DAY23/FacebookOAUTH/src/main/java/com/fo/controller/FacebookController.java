package com.fo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacebookController {

	//Temple Run is going to access this endpoint
	//which is going to be protected via OAUTH2.0
	@GetMapping("/welcome")
	public String getMessage() {
		return "This is Facebook Page";
	}
}
