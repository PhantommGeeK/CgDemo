package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMockTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMockTestDemoApplication.class, args);
		System.out.println("Spring Boot Mock Test Demo Application Started...");
		System.out.println("This application demonstrates how to write unit tests using Mockito in a Spring Boot application.");
	}

}
