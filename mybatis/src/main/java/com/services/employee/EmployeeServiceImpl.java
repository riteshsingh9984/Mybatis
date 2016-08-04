package com.services.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mappers.EmployeeMapper;
import com.models.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Transactional
	public void insertEmployee(Employee employee) {
		employeeMapper.insertEmployee(employee);
	}

	public boolean getEmployeeByUserName(String userName) {
		Employee employee = employeeMapper.getEmployeeByEmployeeName(userName);
		
		if(employee != null) {
			return true;
		}
		
		return false;
	}
	public List<Employee> getEmployeeList(){
		List<Employee> employeeList = employeeMapper.getEmployeeList();
		return employeeList;
	}
	
	public void deleteById(String id){
		employeeMapper.getDeleteById(id);
	}
	
	public Employee getEmployeeById(String id){
		return employeeMapper.getEmployeeById(id) ;
	}
	
	public void  getUpdate(Employee employee){
		employeeMapper.getupdate(employee);
	}
}
