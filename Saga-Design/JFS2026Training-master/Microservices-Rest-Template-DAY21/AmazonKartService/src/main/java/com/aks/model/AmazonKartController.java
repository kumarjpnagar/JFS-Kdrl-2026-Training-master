package com.aks.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AmazonKartController {

	List<Product> productKart = new ArrayList<>();
	
	@Autowired
	RestTemplate restTemplate;
	
	String addressUrl="http://AMZ-MAIN-SERVICE/welcome";
	String addressUrl1="http://AMZ-MAIN-SERVICE/product";
	@GetMapping("/prod")
	public List<Product> addProductIntokart(){
		Product p = restTemplate.getForObject(addressUrl1, Product.class);
		productKart.add(p);
		return productKart;
	}
	
	@GetMapping("/wel")
	public String getWelcomeMessage() {
		return restTemplate.getForObject(addressUrl, String.class);
	}
}
