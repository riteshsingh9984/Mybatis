package com.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.models.Employee;

public interface EmployeeMapper {

	@Insert("INSERT INTO employee(employeeName,salary,createdAt,email) VALUES"
			+ "(#{employeeName},#{salary}, #{createdAt}, #{email})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertEmployee(Employee employee);
	
	@Select("SELECT EMPLOYEENAME as employeeName, SALARY as salary, "
			+ "EMAIL as email, CREATEDAT as createdAt "
			+ "FROM employee WHERE employeeName = #{employeeName}")
	public Employee getEmployeeByEmployeeName(String employeeName);
	
	@Select("SELECT ID as id ,EMPLOYEENAME as employeeName, SALARY as salary, "
			+ "EMAIL as email, CREATEDAT as createdAt "
			+ "FROM employee WHERE id = #{id}")
	public Employee getEmployeeById(String id);
	
	@Select("SELECT * FROM employee")
	public List<Employee> getEmployeeList();
	
	@Delete("DELETE FROM employee WHERE ID=#{id}")
	public void getDeleteById(String id);
	
	@Update("UPDATE employee set employeeName=#{employeeName} "
			+ ",salary=#{salary},email=#{email}, "
			+ "createdAt=#{createdAt} WHERE id=#{id}")
	public void getupdate(Employee employee);
}
