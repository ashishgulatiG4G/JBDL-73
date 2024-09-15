package com.major.user_service;

import com.major.user_service.dao.UserRepository;
import com.major.user_service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String transactionUser = "txn-service";
//		String password = "1234";
//		userRepository.save(User.builder()
//				.username(transactionUser)
//				.password(new BCryptPasswordEncoder().encode(password))
//				.authorities("svc")
//				.build());

	}
}
