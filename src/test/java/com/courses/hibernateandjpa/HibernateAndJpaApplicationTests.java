package com.courses.hibernateandjpa;

import com.courses.hibernateandjpa.dao.PersonDao;
import com.courses.hibernateandjpa.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = "com.courses.hibernateandjpa.dao")
@ActiveProfiles("default")
class HibernateAndJpaApplicationTests {

	@Autowired
	PersonDao personDao ;

	@Test
	void  savePersonTest() {
		Person person = new Person("Mike","New York", LocalDate.now()) ;
		personDao.savePerson(person) ;
		assertThat(person.getId()).isNotNull() ;
	}

	@Test
	void findPersonByIdTest() {
		Person person = new Person("Mike","New York", LocalDate.now()) ;
		personDao.savePerson(person) ;
		Long id = person.getId() ;
		assertThat(personDao.findById(id)).isNotNull() ;


	}

}
