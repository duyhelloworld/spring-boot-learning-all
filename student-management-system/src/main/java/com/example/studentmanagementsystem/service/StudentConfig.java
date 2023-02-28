package com.example.studentmanagementsystem.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.repo.StudentRepo;

@Configuration
public class StudentConfig {
    @Bean(autowireCandidate = true)
    CommandLineRunner commandLineRunner(StudentRepo repo) {
        return args -> {
            Student hs1 = new Student("Pham Duy",
            LocalDate.of(2003, Month.DECEMBER, 9),
            1.75f,
            "codedao",
            "");
            Student hs2 = new Student("Viet Hoang",
            LocalDate.of(2003, Month.FEBRUARY, 11),
            1.65f,
            "hoangdanau",
            "vtv");

            Student hs3 = new Student("Quang Cuon",
            LocalDate.of(2002, Month.OCTOBER, 23),
            1.85f,
            "cuadong@mail",
            "Dep trai");

            Student hs4 = new Student("Pham Duy",
            LocalDate.of(2003, Month.JULY, 5),
            1.75f,
            "codedaongaongao",
            "dz");

            // repo.save(hs1);
            // repo.save(hs2);
            // repo.save(hs3);
            // repo.save(hs4);

            repo.saveAll(
                List.of(hs1, hs2, hs3, hs4)
            );
        };
    }
}
