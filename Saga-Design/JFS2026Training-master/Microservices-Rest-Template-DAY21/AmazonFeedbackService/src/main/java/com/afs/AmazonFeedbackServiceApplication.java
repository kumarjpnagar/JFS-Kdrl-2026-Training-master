package com.afs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmazonFeedbackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonFeedbackServiceApplication.class, args);
	}

}
