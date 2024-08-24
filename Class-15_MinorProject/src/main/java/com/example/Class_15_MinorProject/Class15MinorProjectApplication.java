package com.example.Class_15_MinorProject;

import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.repository.StudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Class15MinorProjectApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Class15MinorProjectApplication.class);
	@Autowired
	StudentDao studentDao;


	public static void main(String[] args) {
		log.info("Here in main");
		SpringApplication.run(Class15MinorProjectApplication.class, args);
		log.info("Here after run");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Here while run");
//		Student student = Student.builder()
//				.name("ABC")
//				.email("xyz@gmail.com")
//				.rollNumber("2k24/CO/01")
//				.age(18)
//				.build();
//
//		studentDao.save(student);
	}
}
