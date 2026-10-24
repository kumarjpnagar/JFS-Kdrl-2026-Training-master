package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.dao.CustomerDAO;

@SpringBootApplication
public class SpringJdbcInMemoryBatchUpdateApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcInMemoryBatchUpdateApplication.class, args);
	}

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public void run(String... args) throws Exception {
	
		customerDAO.doBatchUpdate();
	}
}
