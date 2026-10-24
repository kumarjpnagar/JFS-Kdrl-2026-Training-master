package com.demo.messagingservice;

public class FaceBookMessage implements MessageService {
	public void sendMessage(String message) {

		System.out.println("Facebook" + message);

	}
}
