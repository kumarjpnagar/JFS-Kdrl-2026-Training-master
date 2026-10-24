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
		
		
		UserServiceImplementation obj1 = context.getBean(UserServiceImplementation.class);
		
		UserServiceImplementation obj2 = context.getBean(UserServiceImplementation.class);
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1==obj2);
		
		obj1.processMessage("Hi, John Just to Say Hi...");
		
		//context.close();
		
		UserServiceImplementation obj3 = context.getBean(UserServiceImplementation.class);
		
		//context.registerShutdownHook();
	}
}
