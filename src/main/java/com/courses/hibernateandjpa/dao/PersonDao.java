package com.courses.hibernateandjpa.dao;

import com.courses.hibernateandjpa.entities.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional // this obj managed transaction operation ;
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager ;

    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person ;
    }

    public Person findById(Long id) {
        return  entityManager.find(Person.class,id) ;

    }
    public  void deleteById(Long id ) {
        Person person = findById(id) ;
        entityManager.remove(person);

    }
    public Person  updatePerson(Person person) {
        return entityManager.merge(person) ;

    }
}
