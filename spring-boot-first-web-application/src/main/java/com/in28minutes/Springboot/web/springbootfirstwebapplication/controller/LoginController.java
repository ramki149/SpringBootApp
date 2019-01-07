package com.in28minutes.Springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.Springboot.web.springbootfirstwebapplication.service.LoginService;

/*
 * This is the controller class for SpringBootFirstWebApplication
 */

@Controller
public class LoginController
{

	//Autowire or Inject it.
//	@Autowired //This refers Spring bean with @Component annotation
//	LoginService loginService;

	@RequestMapping(value="/login")
	public String loginPage() {
		return "login";
	}

	//Spring Security removes this
//	@RequestMapping(value="/login", method = RequestMethod.POST) //URL
//	public String loginMessage(@RequestParam String username, @RequestParam String password, ModelMap model) {
//
//		if(loginService.verifyLogin(username, password)) {
//			model.put("username", username); //Setting param property to the model
//			return "welcomepage";
//		}
//
//		return "error"; //jsp file name without extn. View resolver specified in application.properties
//	}
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		
		return principal.toString();
	}

}
