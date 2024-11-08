package com.dshivana.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@GetMapping("/book")
	public ModelAndView getBookName(@RequestParam String authorName) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if(authorName.equals("StephenKing")) {
			modelAndView.addObject("Message", "The Shining");
		}
		if (authorName.equals("AgathaChristie")) {
			modelAndView.addObject("Message", "Death on the nile");
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/bookDetails")
	public ModelAndView getBookDetails(@RequestParam String authorName,Integer publishDate) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if(authorName.equals("StephenKing")) {
			modelAndView.addObject("Message", "The Shining, Published in "+publishDate);
		}
		if (authorName.equals("AgathaChristie")) {
			modelAndView.addObject("Message", "Death on the nile, Published in "+publishDate);
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
