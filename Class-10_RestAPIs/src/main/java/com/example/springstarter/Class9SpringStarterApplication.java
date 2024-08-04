package com.example.springstarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Class9SpringStarterApplication {



	public static void main(String[] args) {

		SpringApplication.run(Class9SpringStarterApplication.class, args);
	}

}

/*

	Spring + Boot -> Spring framework + Bootstrapping

	@SpringBootApplication -> 3 annotations,
		1. @EnableAutoConfiguration -> Enables spring boot auto configuration, automatically configures
							beans based on classpath dependencies
		2. @ComponentScan -> Tells spring to scan for components, service, repo, controller
							in all the packages
		3. @Configuration -> Marks a class as source for beans


		Beans -> [java objects] managed by Spring IOC container
			How to create them -> @Bean, by defining the class as @Compnent [Automatic]

 */
