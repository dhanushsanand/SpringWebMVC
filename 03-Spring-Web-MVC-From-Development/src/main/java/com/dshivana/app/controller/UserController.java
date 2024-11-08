package com.dshivana.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dshivana.app.binding.User;

@Controller
public class UserController {
	
	@GetMapping("/")
	public String loadFrom() {
		return "index";
	}
	
	@PostMapping("/user")
	public String handleSubmitButton(User user,Model model) {
		System.out.println(user);
		model.addAttribute("Message", "User Saved");
		return "index";
	}
}
