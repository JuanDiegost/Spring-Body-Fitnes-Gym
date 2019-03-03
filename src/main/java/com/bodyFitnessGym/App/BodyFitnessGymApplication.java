package com.bodyFitnessGym.App;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.builder.SpringApplicationBuilder;
import com.bodyFitnessGym.model.entity.Alumno;
import com.bodyFitnessGym.storage.StorageService;

@SpringBootApplication(scanBasePackages={"com.bodyFitnessGym"})
@EnableJpaRepositories("com.bodyFitnessGym.repository")
@EntityScan(basePackageClasses = Alumno.class)
public class BodyFitnessGymApplication implements CommandLineRunner {

	@Resource
	StorageService storageService;
	
	public static void main(String[] args) {
		// System.setProperty("server.port","7324");
		SpringApplication.run(BodyFitnessGymApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BodyFitnessGymApplication.class);
	}
	
	@Override
	public void run(String... arg) throws Exception {
		storageService.init();
	}

}