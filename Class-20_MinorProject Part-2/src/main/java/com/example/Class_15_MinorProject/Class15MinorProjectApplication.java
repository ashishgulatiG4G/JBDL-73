package com.example.Class_15_MinorProject;

import com.example.Class_15_MinorProject.models.Admin;
import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.models.User;
import com.example.Class_15_MinorProject.repository.AdminDao;
import com.example.Class_15_MinorProject.repository.StudentDao;
import com.example.Class_15_MinorProject.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Class15MinorProjectApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Class15MinorProjectApplication.class);
//	@Autowired
//	AdminService adminService;


	public static void main(String[] args) {
		log.info("Here in main");
		SpringApplication.run(Class15MinorProjectApplication.class, args);
		log.info("Here after run");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Here while run");
//		Admin admin = Admin.builder()
//				.name("Manish Gupta")
//				.email("manishgupta1@gmail.com")
//				.user(User.builder()
//						.username("manishgupta")
//						.password("123456789")
//						.build())
//				.build();
//		adminService.createAdmin(admin);
	}
}
