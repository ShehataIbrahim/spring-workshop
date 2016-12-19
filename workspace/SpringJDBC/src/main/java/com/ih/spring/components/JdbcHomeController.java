package com.ih.spring.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ih.spring.components.jdbc.User;
import com.ih.spring.components.jdbc.UserDao;

@Controller
public class JdbcHomeController {
	@Autowired
	UserDao userService;
	@RequestMapping(value="/home")
public String goHome(ModelMap model)
{
		User user=userService.findUser("shehata");
		model.addAttribute("user", user);
	return "home";
}
}
