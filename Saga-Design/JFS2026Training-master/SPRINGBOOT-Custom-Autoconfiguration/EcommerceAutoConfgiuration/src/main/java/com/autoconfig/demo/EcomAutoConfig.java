package com.autoconfig.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autoconfig.demo.service.ProductService;

@Configuration
@ConditionalOnClass(value = ProductService.class)
//@ConditionalOnClass(value = {Sabari.class})
//@ConditionalOnMissingClass(value = {Sabari.class})
//@ConditionalOnMissingBean(name = {"dataSource"})
public class EcomAutoConfig {
	
	@Bean
	@ConditionalOnProperty(name = "autoconfigure.ps.enabled",havingValue = "true")
	public ProductService productService() {
		System.out.println("Product Service is Getting Instantiated at the Time of Bootstrapping");
		return new ProductService();
	}
}
