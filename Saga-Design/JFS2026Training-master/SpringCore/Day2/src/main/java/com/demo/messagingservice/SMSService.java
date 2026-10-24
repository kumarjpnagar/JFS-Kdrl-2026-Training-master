package com.demo.messagingservice;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("sms")
//@Repository
public class SMSService implements MessageService {

	public void sendMessage(String message) {
		
		System.out.println("SMS:" +message);
		
	}
}
