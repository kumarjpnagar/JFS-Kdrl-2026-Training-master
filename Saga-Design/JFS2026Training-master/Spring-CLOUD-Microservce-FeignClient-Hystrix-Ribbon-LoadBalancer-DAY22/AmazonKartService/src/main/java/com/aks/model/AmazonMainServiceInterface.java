package com.aks.model;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AMZ-Main-Service",fallback = AmazonMainFallback.class)
public interface AmazonMainServiceInterface {

	@GetMapping("/welcome")
	public String getAmazonDeatils();
	
	@GetMapping("/product")
	public Product getProduct();
}
