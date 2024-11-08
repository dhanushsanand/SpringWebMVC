package com.dshivana.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@GetMapping("/welcome")
	public ModelAndView getMessage() 
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message","Welcome to the Web Server");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/greet")
	public String getGreetMessage(@RequestParam String name, Model model)
	{
		model.addAttribute("Message", name+" Good Evening!");
		return "index";
	}
	
	
}
