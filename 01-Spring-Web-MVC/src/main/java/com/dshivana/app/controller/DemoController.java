package com.dshivana.app.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	
	@GetMapping("/date")
	public ModelAndView getTodayDate() {
		ModelAndView modelAndView = new ModelAndView();
		LocalDate date = LocalDate.now();
		String messageText = "Todays Date is: "+date;
		modelAndView.addObject("Message", messageText);
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
