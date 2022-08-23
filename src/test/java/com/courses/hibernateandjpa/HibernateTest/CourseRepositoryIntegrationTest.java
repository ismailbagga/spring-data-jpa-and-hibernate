package com.courses.hibernateandjpa.HibernateTest;


import com.courses.hibernateandjpa.dao.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = "com.courses.hibernateandjpa.dao")
public class CourseRepositoryIntegrationTest {

    @Autowired
    CourseRepository courseRepository ;


    @Test()
    void findCourseById() {
//        courseRepository.save() ;
        var course =  courseRepository.findById(1000L) ;
        assertThat(course).isNotNull() ;
    }
}
