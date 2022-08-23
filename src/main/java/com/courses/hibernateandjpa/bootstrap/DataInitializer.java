package com.courses.hibernateandjpa.bootstrap;


import com.courses.hibernateandjpa.dao.PersonDao;
import com.courses.hibernateandjpa.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer implements CommandLineRunner {
    @Autowired
    PersonDao personDao ;

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person("Mike","New York", LocalDate.now()) ;
        personDao.savePerson(person) ;

    }
}
