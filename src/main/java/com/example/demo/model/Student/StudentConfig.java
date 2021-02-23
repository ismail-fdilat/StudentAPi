package com.example.demo.model.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository SRepository){
        return arg->{
            Student hassan = new Student(
                    "hassan",
                    "hassan@gmail.com",
                    LocalDate.of(2000, 10, 20)
            );
            Student mariam = new Student(
                    "mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2004, 10, 20)

            );
         SRepository.saveAll(List.of(mariam,hassan));
        };
    }
}
