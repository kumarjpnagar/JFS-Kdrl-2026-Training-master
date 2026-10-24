package com.aks.model;

import org.springframework.stereotype.Component;

@Component
public class AmazonMainFallback implements AmazonMainServiceInterface{

	public String getAmazonDeatils() {
		// TODO Auto-generated method stub
		return "Service Not Available";
	}
	
	public Product getProduct() {
		// TODO Auto-generated method stub
		return new Product(0,"Sorry THe Serive is Down",0.0f);
	}
}
