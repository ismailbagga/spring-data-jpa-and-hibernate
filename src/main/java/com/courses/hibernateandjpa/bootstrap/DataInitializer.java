package com.courses.hibernateandjpa.bootstrap;


import com.courses.hibernateandjpa.repositories.CourseRepository;
import com.courses.hibernateandjpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired()

    private StudentRepository studentRepository ;
    @Autowired
    @Qualifier("repo")
    private CourseRepository courseRepository ;

    @Override
    public void run(String... args) throws Exception {
       studentRepository.saveStudentWithCourses();
    }
}
