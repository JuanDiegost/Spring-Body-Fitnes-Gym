package com.bodyFitnessGym.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BodyFitnessGymApplication {

	public static void main(String[] args) {
		System.setProperty("server.port","80");
		SpringApplication.run(BodyFitnessGymApplication.class, args);
		
	}

}

