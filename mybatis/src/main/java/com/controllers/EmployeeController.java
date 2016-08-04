package com.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.models.Employee;
import com.services.employee.EmployeeService;

@Controller
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	//@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String signup(Model model) throws Exception {
		
		Employee emp = new Employee();
		Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		emp.setCreatedAt(date);
		emp.setEmail("dsafasdfa");
		emp.setEmployeeName("HHH123");
		emp.setSalary("3253252");
		//EmployeeRepository repo = (EmployeeRepository)ApplicationBeanLoader.INSTANCE.getBean("employeeRepository");
		
		//repo.insertEmployee(emp);
		employeeService.insertEmployee(emp);
		
		return null;
	}
}
