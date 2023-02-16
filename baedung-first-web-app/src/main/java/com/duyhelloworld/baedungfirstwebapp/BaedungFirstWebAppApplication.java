package com.duyhelloworld.baedungfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.duyhelloworld.baedungfirstwebapp.repo")
@EntityScan(basePackages = "com.duyhelloworld.baedungfirstwebapp.model")
@SpringBootApplication
// = @EnableAutoConfiguration
// + @ComponentScan
// + Configuration
public class BaedungFirstWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaedungFirstWebAppApplication.class, args);
	}
}
