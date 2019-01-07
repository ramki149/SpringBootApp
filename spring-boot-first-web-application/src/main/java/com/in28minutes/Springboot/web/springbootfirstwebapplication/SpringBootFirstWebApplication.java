package com.in28minutes.Springboot.web.springbootfirstwebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args); //Returns ConfigurableApplicationContext (which extends Application Context)
	}

}

