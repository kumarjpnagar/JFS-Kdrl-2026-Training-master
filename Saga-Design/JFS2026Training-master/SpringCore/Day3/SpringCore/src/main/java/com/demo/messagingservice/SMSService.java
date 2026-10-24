package com.demo.messagingservice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service("sms")
//@Repository
public class SMSService implements MessageService {

	@PostConstruct()
	public void init() {
		// add some resource for the instance
		System.out.println("The SMS Instance Got Created!");
	}

	@PreDestroy()
	public void destroy() {
		// clean up resource work of code
		System.out.println("The SMS Instance Is About to Get Destroy");
	}
	public void sendMessage(String message) {
		
		System.out.println("SMS:" +message);
		
	}
}
