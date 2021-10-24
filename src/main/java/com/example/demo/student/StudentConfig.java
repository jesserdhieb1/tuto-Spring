package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariem = new Student("Mariam","mariam.jmal@gmail.com", LocalDate.of(1999, OCTOBER,15));
            Student alex = new Student("Alex","Alex.jmal@gmail.com", LocalDate.of(2004, OCTOBER,15));
            repository.saveAll(List.of(mariem,alex));
        };
    }
}
