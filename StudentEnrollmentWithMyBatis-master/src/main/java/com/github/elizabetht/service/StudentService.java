package com.github.elizabetht.service;

import java.util.List;

import com.github.elizabetht.model.Student;

public interface StudentService {
	void insertStudent(Student student);
	boolean getStudentByLogin(String userName, String password);
	boolean getStudentByUserName(String userName);
	List<Student> getStudentList();
	void deleteById(String id);
	Student getStudentById(String id);
	void getUpdate(Student student);
	
}
