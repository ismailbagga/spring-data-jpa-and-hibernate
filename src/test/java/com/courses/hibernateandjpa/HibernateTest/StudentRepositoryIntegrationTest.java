package com.courses.hibernateandjpa.HibernateTest;

import com.courses.hibernateandjpa.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest()
@ComponentScan(basePackages = "com.courses.hibernateandjpa.repositories")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryIntegrationTest {

    @Autowired
    StudentRepository studentRepository ;



    @Test
    public void saveStudentWithPassportTest(){

        studentRepository.saveStudentWithPassport();

    }

}
