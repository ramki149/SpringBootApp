package com.in28minutes.Springboot.web.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller("error") //-->Controller for Exception handling
public class ErrorController
{
	
	public ModelAndView handleException(HttpServletRequest req, HttpServletResponse res, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		
		return mv;
	}
	
}