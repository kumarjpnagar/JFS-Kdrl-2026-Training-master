package com.demo.messagingservice;

public class TwitterService implements MessageService {

	private int shortMessageLines;

	public TwitterService() {
		// TODO Auto-generated constructor stub
	}
	
	public TwitterService(int shortMessageLines) {
		this.shortMessageLines = shortMessageLines;
	}

	// Implementation for the Contract method is defined here
	public void sendMessage(String message) {

		if (this.shortMessageLines <= 4)
			System.out.println(message);
		else
			System.out.println("Sorry the Tweet is more than 4 lines!.. ");

	}
}
