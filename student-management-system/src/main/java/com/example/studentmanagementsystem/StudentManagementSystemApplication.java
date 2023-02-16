package com.example.studentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import com.example.studentmanagementsystem.student.*;

@SpringBootApplication
// @RestController
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	// @GetMapping("/")
	// public String hello_world() {
	// 	return "<h1>Hello World</h1>";
	// }

	// @GetMapping("/json-example")
	// public List<String> jsonExample() {
	// 	return List.of("Title", "Content", "Footer", "About Us");
	// }

	// @GetMapping("/student")
	// public List<Student> Students() {
	// 	return List.of(
	// 			new Student("Duy",
	// 					19,
	// 					LocalDate.of(2003, Month.DECEMBER, 9),
	// 					"codedao")
	// 	);
	// }

}
