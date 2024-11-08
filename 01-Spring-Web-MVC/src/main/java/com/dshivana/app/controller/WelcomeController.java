package com.dshivana.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "Welcome To MAV");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/greet")
	public ModelAndView getGreetMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "Welcome To Presidential Election 2024");
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
