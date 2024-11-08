package com.dshivana.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dshivana.binding.Student;
import com.dshivana.entity.StudentEntity;
import com.dshivana.repository.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public String getStudentRegistrationPage(Model model, Student student) {
		initializeData(model);
		model.addAttribute("student", student);
		return "index";
	}

	@PostMapping("/save")
	public String saveStudentDetails(Student student, Model model) {
		System.out.println(student);

		StudentEntity studentEntity = new StudentEntity();
		BeanUtils.copyProperties(student, studentEntity);
		studentEntity.setTimings(Arrays.toString(student.getTimings()));
		studentRepository.save(studentEntity);
		System.out.println("Student Details Saved");
		model.addAttribute("Message", "Student Details Saved");
		initializeData(model);
		return "index";
	}

	private void initializeData(Model model) {
		List<String> coursesList = new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("Python");
		coursesList.add("AWS");

		List<String> timingsList = new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");

		model.addAttribute("timings", timingsList);
		model.addAttribute("courses", coursesList);
	}
}
