package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.demo.messagingservice.EmailService;
import com.demo.messagingservice.FaceBookMessage;
import com.demo.messagingservice.SMSService;
import com.demo.messagingservice.TwitterService;
import com.demo.messagingservice.UserServiceImplementation;

@Configuration
@ComponentScan(basePackages = {"com.demo"}) //This annotation will help us in scanning all 
//Spring Bean Components automaticall and start creating instances
@PropertySource({"classpath:application.properties"})
public class MessagingSystemConfiguration {

	@Bean("fb")
	public FaceBookMessage fbMessage() {
		return new FaceBookMessage();
	}
}







//I have removed all Manual  Configurations
//@Bean
//public TwitterService twitterService1() {
//	TwitterService twitterService = new TwitterService(4);
//	return twitterService;
//}

//@Bean
//public TwitterService twitterService2() {
//	TwitterService twitterService = new TwitterService();
//	return twitterService;
//}

//@Bean
//public SMSService smsService() {
//	SMSService smsService = new SMSService();
//	return smsService;
//}
//
//@Bean(name = "email")
//public EmailService emailService() {
//	EmailService emailService = new EmailService();
//	return emailService;
//}

//@Bean
////@Scope("prototype")
//public UserServiceImplementation userServiceImplementation() {
//	
//	UserServiceImplementation userService = new UserServiceImplementation();
//	
//	//we are wiring the twitterService instance to userService
//	//via setter based wiring strategy
//	//userService.setTweet(twitterService1());
//	
//	return userService;
//	
//}
