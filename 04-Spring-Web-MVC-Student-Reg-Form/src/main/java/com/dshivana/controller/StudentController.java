package com.dshivana.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dshivana.binding.Student;
import com.dshivana.entity.StudentEntity;
import com.dshivana.repo.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository repository;

	@GetMapping("/")
	public String loadForm(Model model) {
		loadFormData(model);
		return "index";
	}

	@PostMapping("/save")
	public String handleSubmit(Student s, Model model) {
		System.out.println(s);
		StudentEntity entity = new StudentEntity();

		BeanUtils.copyProperties(s, entity);

		entity.setTimings(s.getTimings().toString());
		repository.save(entity);
		loadFormData(model);
		model.addAttribute("Message", "Student Details Saved");
		return "index";
	}

	private void loadFormData(Model model) {
		List<String> courseList = new ArrayList<>();
		courseList.add("Java");
		courseList.add("Python");
		courseList.add("AWS");

		List<String> timingsList = new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");

		Student student = new Student();

		model.addAttribute("courses", courseList);
		model.addAttribute("timings", timingsList);
		model.addAttribute("student", student);
	}
}
