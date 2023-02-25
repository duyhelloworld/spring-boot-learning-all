package com.example.studentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	/*
	 * @Bean
	 * CommandLineRunner commandLineRunner(StudentRepo repo) {
	 * return args -> {
	 * Student hs1 = new Student("Pham Duy",
	 * 18,
	 * LocalDate.of(2003, 12, 9),
	 * 1.75f,
	 * "codedao",
	 * "");
	 * Student hs2 = new Student("Viet Hoang",
	 * 18,
	 * LocalDate.of(2003, 2, 11),
	 * 1.65f,
	 * "coooo",
	 * "");
	 * 
	 * Student hs3 = new Student("Quang Cuon",
	 * 21,
	 * LocalDate.of(2002, 10, 23),
	 * 1.85f,
	 * "cuadong@mail",
	 * "Dep trai");
	 * 
	 * Student hs4 = new Student("Pham Duy",
	 * 19,
	 * LocalDate.of(2003, 10, 5),
	 * 1.75f,
	 * "codedao",
	 * "");
	 * 
	 * repo.save(hs1);
	 * repo.save(hs2);
	 * repo.save(hs3);
	 * };
	 * }
	 */
}
