package com.ams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ams.model.Product;

@RestController
public class AmazonController {

	@GetMapping("/welcome")
	public String getAmazonDeatils() {
		return "Welcome TO Amazon Portal";
	}
	
	@GetMapping("/product")
	public Product getProduct() {
		return new Product(101,"I-Pad",234.45f);
	}
}
