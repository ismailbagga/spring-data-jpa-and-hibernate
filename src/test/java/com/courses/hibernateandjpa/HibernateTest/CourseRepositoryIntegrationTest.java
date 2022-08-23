package com.courses.hibernateandjpa.HibernateTest;


import com.courses.hibernateandjpa.dao.CourseRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


//@SpringBootTest
@ActiveProfiles("local")
@DataJpaTest()
@ComponentScan(basePackages = "com.courses.hibernateandjpa.dao")
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourseRepositoryIntegrationTest {

    @Autowired
    CourseRepository courseRepository ;


    @Test()
    void findCourseById() {
//        courseRepository.save() ;
        var course =   courseRepository.findById(1000L) ;
        assertThat(course).isNotNull() ;
    }
    @Test()
    @DirtiesContext() // this method change db by committing changes To db  this annotation reset context to before this method is called
    void removeCourseById() {
        courseRepository.deleteById(1000L);
        var course =  courseRepository.findById(1000L) ;
        assertThat(course).isNull() ;
    }
    @Test
    @DirtiesContext
    void playAroundWithEntityManager() {
        courseRepository.playWithEntityManager();
    }
}
