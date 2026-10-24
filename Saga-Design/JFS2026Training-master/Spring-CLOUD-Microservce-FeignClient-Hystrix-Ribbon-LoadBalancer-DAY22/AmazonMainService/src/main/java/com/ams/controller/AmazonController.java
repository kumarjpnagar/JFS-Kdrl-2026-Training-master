package com.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.model.Product;

@RestController
public class AmazonController {

	//@Value("${local.server.port}")
	//String port;
	@Autowired
	Environment env;
	
	@GetMapping("/welcome")
	public String getAmazonDeatils() {
		return "Welcome TO Amazon Portal: "+env.getProperty("local.server.port");
	}
	
	@GetMapping("/product")
	public Product getProduct() {
		return new Product(101,"I-Pad",234.45f);
	}
}
