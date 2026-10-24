package com.ba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ba.model.Employee;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {
	
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		System.out.println("Row Number: "+ rowNum);
		Employee employee = new Employee();
		
		employee.setEmpId(rs.getInt("empid"));
		employee.setEmpName(rs.getString("empname"));
		employee.setEmpSalary(rs.getInt("empsalary"));
		
		return employee;
	}
}
