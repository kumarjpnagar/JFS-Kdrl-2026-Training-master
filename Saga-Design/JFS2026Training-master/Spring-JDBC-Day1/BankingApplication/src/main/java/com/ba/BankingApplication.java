package com.ba;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ba.model.Employee;
import com.ba.service.DepositService;
import com.ba.service.EmployeeService;

@SpringBootApplication
@PropertySource(value = { "classpath:sabari.properties" })
public class BankingApplication implements CommandLineRunner {

//	SpringApplication
//	Class that can be used to bootstrap and launch a Spring application from a 
//	Java main method. By default class will perform the following 
//	steps to bootstrap your application: 
//		•Create an appropriate ApplicationContext instance (depending on your classpath)
//		•Register a CommandLinePropertySource to expose command line arguments as Spring properties
//		•Refresh the application context, loading all singleton beans
//		•Trigger any CommandLineRunner beans

	// Entry Point
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BankingApplication.class, args);
		// DepositService ds = context.getBean(DepositService.class);
		// ds.disp();
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	EmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {

		// Performing a DDL Operation
		// jdbcTemplate.execute("create table employees(" + "empid int, empname
		// varchar(20),empsalary int)");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter EmpID:");

		int empId = scanner.nextInt();

//		System.out.println("Enter EmpName:");
//
//		 String empName = scanner.next();
//
//		System.out.println("Enter EmpSalary:");
//
//		int empSalary = scanner.nextInt();
//
//		 Employee employee = new Employee(empId, empName, empSalary);
//
//		boolean result = employeeService.insertEmployeeData(employee);
//		System.out.println(result);
		//boolean result = employeeService.updateEmployeeData(empId, empSalary);
		//System.out.println(result);
		//boolean result = employeeService.deleteEmployeeData(empId);
		//System.out.println(result);
		
		//employeeService.getAllEmployeesData().forEach(System.out::println);
		Employee employee = employeeService.findByEmployeeId(empId);
		System.out.println(employee);
		
		System.out.println(dataSource);
	}
	

}
