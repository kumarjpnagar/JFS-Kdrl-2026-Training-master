package com.rba.demo;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rba.demo.model.Book;
import com.rba.demo.model.FictionBook;
import com.rba.demo.model.StoryBook;

@SpringBootApplication
public class RoomBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public ModelMapper getModelMapper() {
		
		ModelMapper modelMapper =  new ModelMapper();
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return modelMapper;
	}
	
	@Bean
	@Profile("dev")
	public Book storyBook() {
		
		Book b = new StoryBook("Alice In Wonderland");
		return b;
	}
	
	@Bean
	@Profile("prod")
	public Book fictionBook() {
		
		Book b = new FictionBook("Fiction Book");
		return b;
	}

}
