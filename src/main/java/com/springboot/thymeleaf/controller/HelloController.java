package com.springboot.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.thymeleaf.model.Student;

@Controller
public class HelloController {
 
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mv = new ModelAndView("data");
	    mv.addObject("message", "Take up one idea and make it your life");
		return mv;
	}
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mv = new ModelAndView("student");
		Student std = new Student();
		std.setName("chamundeswari");
		std.setScore(99);
	    mv.addObject("student",std);
		return mv;
	}
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mv = new ModelAndView("studentList");
		
		Student std = new Student();
		std.setName("chamu");
		std.setScore(99);
		
		Student std1 = new Student();
		std1.setName("durga");
		std1.setScore(90);
		
		List<Student> students = Arrays.asList(std,std1);
		
	    mv.addObject("students",students);
		return mv;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView mv = new ModelAndView("studentForm");
		Student std = new Student();
		std.setName("chamu");
		std.setScore(99);
	    mv.addObject("student",std);
		return mv;
	}
	
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student std) {
		ModelAndView mv = new ModelAndView("result");
	    System.out.println(std.getName());
	    System.out.println(std.getScore());
		return mv;
	}
	
	
	
}
