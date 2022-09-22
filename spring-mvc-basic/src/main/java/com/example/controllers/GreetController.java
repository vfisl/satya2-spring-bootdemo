package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	@RequestMapping("/greet")
	public String greetUser(Model model)
	{
		model.addAttribute("message","HAve a great day");
		return "success";
	}
	@RequestMapping("/sayHello")
	public String sayHello(ModelMap map)
	{
		map.addAttribute("message","hello there");
		return "success";
	}
	@RequestMapping("/welcome")
  public ModelAndView welcomeUSer()
  {
	  ModelAndView modelAndView=new ModelAndView("success","message","welcome to vfislk");
	  return modelAndView;
  }
}
