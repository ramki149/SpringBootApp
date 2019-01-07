
package com.in28minutes.Springboot.web.springbootfirstwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{ 
	//Create the user "admin" password "welcome"
	@Autowired public void configureGlobalSecurity(AuthenticationManagerBuilder
			auth) throws Exception 
	{
		auth.inMemoryAuthentication().withUser("admin").password("{noop}welcome").
		roles("USER", "ADMIM"); 
	}

	//Take user to default page
	@Override protected void configure(HttpSecurity http) throws Exception 
	{
		http.authorizeRequests() .antMatchers("/EmployeeReport").permitAll()
		.antMatchers("/", "/").access("hasRole('USER')").and() .formLogin(); 
	}
}
