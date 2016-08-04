package com.services.employee;

import java.util.List;

import com.models.Employee;

public interface EmployeeService {

	void insertEmployee(Employee employee);
	boolean getEmployeeByUserName(String userName);
	List<Employee> getEmployeeList();
	void deleteById(String id);
	Employee getEmployeeById(String id);
	void getUpdate(Employee employee);
}
