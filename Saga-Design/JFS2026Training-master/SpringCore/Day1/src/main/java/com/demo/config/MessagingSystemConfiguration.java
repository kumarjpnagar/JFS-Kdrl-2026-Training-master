package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.messagingservice.TwitterService;
import com.demo.messagingservice.UserServiceImplementation;

@Configuration
public class MessagingSystemConfiguration {

	@Bean
	public TwitterService twitterService1() {
		TwitterService twitterService = new TwitterService(4);
		return twitterService;
	}
	
	@Bean
	public TwitterService twitterService2() {
		TwitterService twitterService = new TwitterService();
		return twitterService;
	}
	
	@Bean
	public UserServiceImplementation userServiceImplementation() {
		
		UserServiceImplementation userService = new UserServiceImplementation(twitterService1());
		
		//we are wiring the twitterService instance to userService
		//via setter based wiring strategy
		//userService.setTweet(twitterService());
		
		return userService;
		
	}
}
