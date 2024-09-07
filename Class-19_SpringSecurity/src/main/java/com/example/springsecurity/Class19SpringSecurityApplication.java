package com.example.springsecurity;

import com.example.springsecurity.model.User;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Class19SpringSecurityApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Class19SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = User.builder()
//				.username("ashish")
//				.password("1234")
//				.roles("ADMIN")
//				.build();

//		userService.saveUser(user);

	}
}
