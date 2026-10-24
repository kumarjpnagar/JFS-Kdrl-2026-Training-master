package com.aks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//RibbonClient(name = "AMZ-MAIN-SERVICE")
public class AmazonKartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonKartServiceApplication.class, args);
	}
	
//	@Bean
//	@LoadBalanced
//	//Annotation to mark a RestTemplate or 
//	//WebClient bean to be configured to use aLoadBalancerClient.
//	public RestTemplate getRestTemplate() {
//		
//		return new RestTemplate();
//	}
	
	//Feign Client - Eureka Server - Fault Tolerance - Hystrix Library

}
