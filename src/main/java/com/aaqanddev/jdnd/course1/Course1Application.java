package com.aaqanddev.jdnd.course1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Course1Application {

	public static void main(String[] args) {
		SpringApplication.run(Course1Application.class, args);
	}

	@Bean
	public Boolean firstVisit(){
		return false;
	}

	@Bean
	public String[] greetings(){
		return new String[]{"Hello, homepage!","Welcome back!"};
	}
}
