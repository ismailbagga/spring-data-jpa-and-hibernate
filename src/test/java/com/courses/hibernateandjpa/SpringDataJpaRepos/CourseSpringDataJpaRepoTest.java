package com.courses.hibernateandjpa.SpringDataJpaRepos;

import com.courses.hibernateandjpa.entities.Course;
import com.courses.hibernateandjpa.repositories.CourseSpringDataJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;

import java.util.List;

@DataJpaTest
@ComponentScan(basePackages = "com.courses.hibernateandjpa.repositories")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class CourseSpringDataJpaRepoTest {

    @Autowired
    CourseSpringDataJpaRepo repository;



    void saveCourses() {
        log.info("Before insert");
        var c1 = new Course("Spring Boot Bootcamp");
        var c2 = new Course("Python 3 ");
        var c3 = new Course("Java Essentials");
        var c4 = new Course("Android Development");
        List<Course> courses = List.of(c1, c2, c3,c4);
        repository.saveAll(courses) ;


    }

    @BeforeEach
    void  repeatedSave() {
        saveCourses();

    }

    @Test
    void findAll() {


        log.info("courses -> {}" ,  repository.findAll()  );

    }
    @Test
    void sort() {
        var sort1  = Sort.by(Sort.Direction.DESC,"name") ;
        var sort2  = Sort.by(Sort.Direction.ASC,"id") ;
        log.info("Course sorted base on name -> {}",repository.findAll(sort1));
        log.info("Course sorted base on id -> {}",repository.findAll(sort2));


    }


}
