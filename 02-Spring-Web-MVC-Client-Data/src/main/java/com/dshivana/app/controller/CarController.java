package com.dshivana.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {
	
	@GetMapping("/car/{carID}/brand/{name}")
	public ModelAndView getCarColor(@PathVariable("carID") Integer carId,@PathVariable("name") String carName) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message","This is "+carName+" with ID:"+carId);
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
