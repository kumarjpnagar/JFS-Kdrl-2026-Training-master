package com.demo.messagingservice;

public class SMSService implements MessageService {

	public void sendMessage(String message) {
		
		System.out.println(message);
		
	}
}
