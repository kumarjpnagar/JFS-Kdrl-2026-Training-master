package com.demo.messagingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //flag will enable the ComponentScan to work effectively
public class UserServiceImplementation implements IUserService {

	//We manually created an instance
	//TightCoupling
	//Loosely Coupled Environment
	
	//Field Level Injection-> using AutoWiring Mechanism
	//resolve ByType - DataType
	//resolve ByName - Bean Instance Name
//	@Autowired
//	@Qualifier(value = "sms")
//	//Whenever your field names should match with
//	//The component Name then you can use @Qualifier
	MessageService smsService; //= new TwitterService(5);
	
	//1. Constructor based Manual Wiring or Injection
	//@Autowired
	public UserServiceImplementation(MessageService fb) {
		//System.out.println("Constructor Called !");
		this.smsService = fb;
	}
	
	//@Autowired
//	public UserServiceImplementation(EmailService email) {
//		
//	}
	
	//2. Setter based Manual Wiring or Injection
//	@Autowired
//	//@Qualifier(value = "sms")
//	public void setTweet(@Value(value = "10") int messageLine,@Qualifier(value = "sms") MessageService service) {
//		System.out.println("Setter Called !");
//		this.smsService = service;
//	}

	
	public void processMessage(String message) {
		//NullPointer Exception
		smsService.sendMessage(message);
		
	}

	}
