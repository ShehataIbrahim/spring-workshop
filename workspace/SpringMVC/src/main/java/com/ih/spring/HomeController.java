package com.ih.spring;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ih.pojo.User;

@Controller
public class HomeController {
	@RequestMapping(value = "/home")
	public ModelAndView goHome() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("msg", "Welcome to Spring FrameWork");
		return model;
	}
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("user",new User());
		return "form";
	}
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String welcome(Locale locale,
			Model model,@ModelAttribute("user") User user) {
		model.addAttribute("userData", user);
		return "result";
	}
}
