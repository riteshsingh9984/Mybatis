package com.github.elizabetht.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.github.elizabetht.model.Student;

public interface StudentMapper {
	@Insert("INSERT INTO student(userName, password, firstName,"
			+ "lastName, dateOfBirth, emailAddress) VALUES"
			+ "(#{userName},#{password}, #{firstName}, #{lastName},"
			+ "#{dateOfBirth}, #{emailAddress})")
	@Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	public void insertStudent(Student student);
		
	@Select("SELECT USERNAME as userName, PASSWORD as password, "
			+ "FIRSTNAME as firstName, LASTNAME as lastName, "
			+ "DATEOFBIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
			+ "FROM student WHERE userName = #{userName}")
	public Student getStudentByUserName(String userName);
	
	@Select("SELECT ID as id ,USERNAME as userName, PASSWORD as password, "
			+ "FIRSTNAME as firstName, LASTNAME as lastName, "
			+ "DATEOFBIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
			+ "FROM student WHERE id = #{id}")
	public Student getStudentById(String id);
	
	@Select("SELECT * FROM student")
	public List<Student> getStudentList();
	
	@Delete("DELETE FROM student WHERE ID=#{id}")
	public void getDeleteById(String id);
	
	
	@Update("UPDATE student set userName=#{userName} "
			+ ",firstName=#{firstName},lastName=#{lastName}, "
			+ "password=#{password} ,emailAddress=#{emailAddress},"
			+ "dateOfBirth=#{dateOfBirth} WHERE id=#{id}")
	public void getupdate(Student student);


}
