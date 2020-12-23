package com.capgemini.census.Censusprofileapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.capgemini.census")
@EntityScan(basePackages = "com.capgemini.census.entity")
@EnableJpaRepositories(basePackages = "com.capgemini.census.repository")
public class CensusProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(CensusProfileApplication.class, args);
	}

}
