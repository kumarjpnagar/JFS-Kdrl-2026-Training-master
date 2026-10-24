package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.config.MessagingSystemConfiguration;
import com.demo.messagingservice.UserServiceImplementation;

public class App {
	public static void main(String[] args) {

		//Representative of our IoC Container
		//This one liner will launch the IoC container at the bootstrap 
		//time of the application
		
		//Feed in the configuration file details
		// ClassPathXmlApplicationContext - we use this class for XML based configuration

		// AnnotationConfigApplicationContext - we use this class for Java Based Configuration
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MessagingSystemConfiguration.class);
		
		
		UserServiceImplementation sabari = context.getBean(UserServiceImplementation.class);
		
		sabari.processMessage("Hi, John Just to Say Hi...");
		
		//context.close();
		//context.registerShutdownHook();
	}
}
