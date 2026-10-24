package com.aop.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aop.demo.model.Account;
import com.aop.demo.service.AccountService;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Autowired
	AccountService accountService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Account account = new Account(101,"Steve Jobs",2000);
		accountService.addAccount(account,9000); //calling the target method from the client
		//accountService.addAccount();
		
	}
}
