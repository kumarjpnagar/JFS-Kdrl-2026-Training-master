package com.demo.messagingservice;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailService implements MessageService {

	public void sendMessage(String message) {

		System.out.println( "Email:" + message );

	}

}
