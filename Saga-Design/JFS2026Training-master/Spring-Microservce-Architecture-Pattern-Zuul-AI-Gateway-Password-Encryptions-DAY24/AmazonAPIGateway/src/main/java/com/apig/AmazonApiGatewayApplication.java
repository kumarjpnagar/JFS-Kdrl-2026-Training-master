package com.apig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy //Enables the API Gateway with default settings
public class AmazonApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonApiGatewayApplication.class, args);
	}

}
