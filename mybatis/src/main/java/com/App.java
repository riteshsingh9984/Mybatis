package com;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.models.Employee;
import com.services.employee.EmployeeService;


public class App {
	
	public App(){
		/*ApplicationContext context = 
		    	 new ClassPathXmlApplicationContext(new String[] {"springConf.xml"});*/
	}
	
	public static void main(String args[]) throws Exception{
		
		
		Employee emp = new Employee();
		Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		emp.setCreatedAt(date);
		emp.setEmail("dsafasdfa");
		emp.setEmployeeName("HHH");
		emp.setSalary("3253252");
		EmployeeRepository repo = (EmployeeRepository)ApplicationBeanLoader.INSTANCE.getBean("employeeRepository");
		
		repo.insertEmployee(emp);
	}
}
