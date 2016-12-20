package com.ih.spring.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ih.spring.components.orm.SecurityUserDao;

@Controller
public class HomeController {
	@Autowired
	SecurityUserDao service;
	@RequestMapping(value="/home")
	public String goHome(ModelMap model)
	{
		model.addAttribute("user", service.findUser("shehata"));
		
		return "home";
	}
}
