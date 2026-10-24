package com.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmazonMainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonMainServiceApplication.class, args);
	}

}
