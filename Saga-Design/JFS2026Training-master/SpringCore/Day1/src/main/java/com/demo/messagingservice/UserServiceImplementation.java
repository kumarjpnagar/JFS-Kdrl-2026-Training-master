package com.demo.messagingservice;

public class UserServiceImplementation implements IUserService {

	//We manually created an instance
	//TightCoupling
	//Loosely Coupled Environment
	TwitterService tweet; //= new TwitterService(5);
	
	//1. Constructor based Manual Wiring or Injection
	public UserServiceImplementation(TwitterService tweet) {
		System.out.println("Constructor Called !");
		this.tweet = tweet;
	}
	
	//2. Setter based Manual Wiring or Injection
	public void setTweet(TwitterService tweet) {
		System.out.println("Setter Called !");
		this.tweet = tweet;
	}

	
	public void processMessage(String message) {
		//NullPointer Exception
		tweet.sendMessage(message);
		
	}

	}
