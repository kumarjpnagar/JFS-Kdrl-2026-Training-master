package com.ba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.ba.service.DepositService;

@SpringBootApplication
@PropertySource(value = {"classpath:sabari.properties"})
public class BankingApplication {

//	SpringApplication
//	Class that can be used to bootstrap and launch a Spring application from a 
//	Java main method. By default class will perform the following 
//	steps to bootstrap your application: 
//		•Create an appropriate ApplicationContext instance (depending on your classpath)
//		•Register a CommandLinePropertySource to expose command line arguments as Spring properties
//		•Refresh the application context, loading all singleton beans
//		•Trigger any CommandLineRunner beans

	
	// Entry Point
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BankingApplication.class, args);
		DepositService ds = context.getBean(DepositService.class);
		ds.disp();
	}

}
