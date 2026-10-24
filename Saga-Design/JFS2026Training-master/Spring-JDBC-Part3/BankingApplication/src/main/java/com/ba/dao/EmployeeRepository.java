package com.ba.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.ba.model.Employee;

@Component
public class EmployeeRepository {

	// From DAO layer you will connect to the Database
	// CRUD
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public boolean insertEmployeeData(Employee employee) {
		// insert or update or delete
		// DML - Operation
		// Place Holders
		int success = 0;
		try {
			// using jdbcTemplate object we are firing the update DML operation
			jdbcTemplate.update("insert into employees values(?,?,?)",
					new Object[] { employee.getEmpId(), employee.getEmpName(), employee.getEmpSalary() });
			success = 1;
			//DataAccessException are UnChecked Exceptions
		} catch (DataAccessException dae) {
			System.out.println("The Error:" + dae.getMessage());
		}
		if (success == 0)
			return false;
		else if(success == 1)
			return true;
		else
			return false;
	}
	
	
	public boolean updateEmployeeData(int empId,int empSalary) {
		// insert or update or delete
		// DML - Operation
		// Place Holders
		int success = 0;
		try {
			// using jdbcTemplate object we are firing the update DML operation
			jdbcTemplate.update("update employees set empsalary = ? where empid=?",
					new Object[] { empSalary,empId});
			success = 1;
			//DataAccessException are UnChecked Exceptions
		} catch (DataAccessException dae) {
			System.out.println("The Error:" + dae.getMessage());
		}
		if (success == 0)
			return false;
		else if(success == 1)
			return true;
		else
			return false;
	}
	
	public boolean deleteEmployeeData(int empId) {
		// insert or update or delete
		// DML - Operation
		// Place Holders
		int success = 0;
		try {
			// using jdbcTemplate object we are firing the update DML operation
			//jdbcTemplate.
			jdbcTemplate.update("delete from employees where empid=?",
					new Object[] { empId});
			success = 1;
			//DataAccessException are UnChecked Exceptions
		} catch (DataAccessException dae) {
			System.out.println("The Error:" + dae.getMessage());
		}
		if (success == 0)
			return false;
		else if(success == 1)
			return true;
		else
			return false;
	}
	
	@Autowired
	EmployeeRowMapper employeeRowMapper;
	
	public List<Employee> getAllEmployeesData(){
		//DQL - Operation
		//RowMapper = ResultSet in traditional JDBC API
		
		List<Employee> employees = jdbcTemplate.query("select * from employees", 
				(rs,rowNum) -> {
					System.out.println(rowNum);
					return new Employee(rs.getInt("empid"),rs.getString("empname")
							,rs.getInt("empsalary"));
				}
						
				);
		return employees;
	}
	
	public Employee findByEmployeeId(int empId) {
		return jdbcTemplate.queryForObject("select * from employees where empid=?", new Object[] {empId},employeeRowMapper);
	}
	
	public int countOfEmployee(Employee employee) {
		
		//String sql = "select count(*) from employees where empname=? and empsalary=?";
		
		String named_param_sql = "select count(*) from employees where empname = :empName and empsalary = :empSalary";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(employee);
		
		//Associating the namedParameters reference to the NamedParameterJdbcTemplate
		return this.namedParameterJdbcTemplate.queryForObject(named_param_sql, namedParameters, Integer.class);
		
		
	}
	
	//How to access selective field from the Table
	
	public void callEmployeeProc() {
		//This step is optional
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		
		simpleJdbcCall.withProcedureName("employees_proc");
		//Passing the IN Parameter of the StoredProcedure
		SqlParameterSource in = new MapSqlParameterSource().addValue("e_id", 105);
		
		Map	out = simpleJdbcCall.execute(in); //call employees_proc(105, @ename, @esal);
		
		System.out.println(out);
		
		
	}
}
