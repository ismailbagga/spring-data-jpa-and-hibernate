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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ComponentScan(basePackages = "com.courses.hibernateandjpa.repositories")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class CourseSpringDataJpaRepoTest {

    @Autowired
    CourseSpringDataJpaRepo repository;


    @Autowired
    EntityManagerFactory entityManagerFactory ;

    void saveCourses() {
        log.info("Before insert");
        var c1 = new Course("Spring Boot Bootcamp");
        var c2 = new Course("Python 3 ");
        var c3 = new Course("Java Essentials");
        var c4 = new Course("Android Development");
        List<Course> courses = List.of(c1, c2, c3,c4);
//        repository.saveAll(courses) ;


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
    @Test
    void firstLevelCash() {
        var temp = entityManagerFactory.createEntityManager() ;
        temp.getTransaction().begin();
        temp.persist(new Course("Spring Boot Bootcamp"));
        temp.getTransaction().commit();



        var entityManager = entityManagerFactory.createEntityManager() ;
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class,1L) ;
        log.info("course first search -> {} ",course1);
        entityManager.detach(course1);
        Course course2 = entityManager.find(Course.class,1L) ;
        log.info("course second search -> {} ",course1);

        assertEquals(course1,course2);
        entityManager.getTransaction().commit();

    }


}
