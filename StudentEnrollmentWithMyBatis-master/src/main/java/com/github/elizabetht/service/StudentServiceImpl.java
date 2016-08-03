package com.github.elizabetht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.elizabetht.mappers.StudentMapper;
import com.github.elizabetht.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional
	public void insertStudent(Student student) {
		studentMapper.insertStudent(student);
	}

	public boolean getStudentByLogin(String userName, String password) {
		Student student = studentMapper.getStudentByUserName(userName);
		
		if(student != null && student.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	public boolean getStudentByUserName(String userName) {
		Student student = studentMapper.getStudentByUserName(userName);
		
		if(student != null) {
			return true;
		}
		
		return false;
	}
	@Override
	public List<Student> getStudentList(){
		List<Student> studentList = studentMapper.getStudentList();
		return studentList;
	}
	
	@Override
	public void deleteById(String id){
		studentMapper.getDeleteById(id);
	}
	
	@Override
	public Student getStudentById(String id){
		return studentMapper.getStudentById(id) ;
	}
	
	@Override
	public void  getUpdate(Student student){
		studentMapper.getupdate(student);
	}
	
}
