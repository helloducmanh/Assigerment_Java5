package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@Autowired HttpServletRequest req;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Welcome spring 123");
		return "index";
	}
}
