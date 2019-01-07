package com.in28minutes.Springboot.web.springbootfirstwebapplication.service;

/* 
 * Spring security removed the purpose of this class
 * 
 */
//Spring Bean
//@Component
public class LoginService
{
	public boolean verifyLogin(String username, String password) {
		if(username.equals("ram") && password.equals("ram")) {
			//Login Success
			return true;
		}else {
			return false;
		}
	}
}