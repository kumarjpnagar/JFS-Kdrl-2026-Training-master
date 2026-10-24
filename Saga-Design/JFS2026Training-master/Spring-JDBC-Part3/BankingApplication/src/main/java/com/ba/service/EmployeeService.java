package com.ba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.dao.EmployeeRepository;
import com.ba.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public boolean insertEmployeeData(Employee employee) {
		return employeeRepository.insertEmployeeData(employee);
	}

	public boolean updateEmployeeData(int empId, int empSalary) {
		return employeeRepository.updateEmployeeData(empId, empSalary);
	}

	public boolean deleteEmployeeData(int empId) {
		return employeeRepository.deleteEmployeeData(empId);
	}

	public List<Employee> getAllEmployeesData() {
		return employeeRepository.getAllEmployeesData();
	}

	public Employee findByEmployeeId(int empId) {
		return employeeRepository.findByEmployeeId(empId);
	}

	public int countOfEmployee(Employee employee) {
		return employeeRepository.countOfEmployee(employee);
	}

	public void callEmployeeProc() {
		employeeRepository.callEmployeeProc();
	}

}
