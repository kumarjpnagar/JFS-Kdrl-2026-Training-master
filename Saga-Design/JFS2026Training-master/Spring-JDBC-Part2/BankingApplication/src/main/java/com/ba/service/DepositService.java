package com.ba.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DepositService {

	@Value("${depositamt}")
	private int maxDepositAmount;
	
	public void disp() {
		
		System.out.println("Deposit Service!..."+maxDepositAmount);
	}
}
