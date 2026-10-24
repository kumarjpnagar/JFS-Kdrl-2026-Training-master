package com.ecom.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.autoconfig.demo.service.Product;
import com.autoconfig.demo.service.ProductService;

@SpringBootApplication
public class AmazonEcomApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AmazonEcomApplication.class, args);
	}
	
	@Autowired
	ProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		Product product = productService.getProduct();
		System.out.println(product.getProductId());
		System.out.println(product.getProductName());
		System.out.println(product.getProductPrice());
		
	}

}
