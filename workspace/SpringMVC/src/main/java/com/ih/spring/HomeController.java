package com.ih.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="home")
public class HomeController {
	@RequestMapping(method=RequestMethod.GET)
public ModelAndView goHome()
{
	ModelAndView model=new ModelAndView("home");
	return model;
}
}
