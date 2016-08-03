package com.github.elizabetht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.elizabetht.model.Student;
import com.github.elizabetht.model.StudentLogin;
import com.github.elizabetht.service.StudentService;

@Controller
@SessionAttributes("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("student") Student student, Model model) {
		if(studentService.getStudentByUserName(student.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			studentService.insertStudent(student);
			model.addAttribute("message", "Saved student details");
			return "redirect:login.html";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		StudentLogin studentLogin = new StudentLogin();
		model.addAttribute("studentLogin", studentLogin);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("studentLogin") StudentLogin studentLogin) {
		boolean found = studentService.getStudentByLogin(studentLogin.getUserName(), studentLogin.getPassword());
		if (found) {				
			return "success";
		} else {				
			return "failure";
		}
	}
	
	@RequestMapping(value="/displayAll", method=RequestMethod.GET)
	public String displayAll(Model model) {
		List<Student> studentList = studentService.getStudentList();
		System.out.println("welcome"+studentList.size());
		model.addAttribute("studentList", studentList);
		return "displayAll";
	}
	
	@RequestMapping(value="/deleteStudent", method=RequestMethod.GET)
	public String deleteStudent(Model model,@RequestParam(value="id")String id) {
		System.out.println("Going to deleted Id is="+id);
		studentService.deleteById(id);
		return "redirect:displayAll.html";
	}
	
	@RequestMapping(value="/updateStudent", method=RequestMethod.GET)
	public String updateStudent(Model model,@RequestParam(value="id")String id ,@ModelAttribute("updateSave") Student student) {
		System.out.println("Going to update Id is="+id);
		student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "update";
	}
	
	@RequestMapping(value="/updateSaveStudent", method=RequestMethod.POST)
	public String updateSave(@ModelAttribute("updateSave") Student student, Model model) {
		System.out.println(student.getId());
		System.out.println(student.getUserName());
		studentService.getUpdate(student);
		return "redirect:displayAll.html";
	}
	
}
