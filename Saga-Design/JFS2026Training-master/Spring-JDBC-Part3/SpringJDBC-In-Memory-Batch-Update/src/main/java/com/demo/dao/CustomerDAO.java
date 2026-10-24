package com.demo.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.model.Customer;

@Component
public class CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void doBatchUpdate() {
		
		//DDL Operation
		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		
		jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name varchar(25),last_name varchar(25))" );
		
		List<String> namesList = Arrays.asList("Sundar Pichai","Sabari Balaji","Steve Jobs","Sundar Menon","Joseph Kurian");
		
		List<Object[]> splitedNames =  namesList.stream()
			.map(name -> name.split(" "))
			.collect(Collectors.toList());
		
		splitedNames.forEach(name -> {System.out.println(name[0] +""+ name[1]);});
		
		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name,last_name) VALUES(?,?)",splitedNames);
		
		
		jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name= ?", new Object[] {"Joseph"},
				(rs,rowNum) -> new Customer(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"))
				).forEach(System.out::println);
	}
}
