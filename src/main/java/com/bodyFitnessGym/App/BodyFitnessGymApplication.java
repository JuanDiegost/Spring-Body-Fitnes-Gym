package com.bodyFitnessGym.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.bodyFitnessGym.repository")
public class BodyFitnessGymApplication {

	public static void main(String[] args) {
		//System.setProperty("server.port","7324");
		SpringApplication.run(BodyFitnessGymApplication.class, args);
		
	}

}

