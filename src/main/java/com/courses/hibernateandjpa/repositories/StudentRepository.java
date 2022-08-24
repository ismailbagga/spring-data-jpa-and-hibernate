package com.courses.hibernateandjpa.repositories ;

import com.courses.hibernateandjpa.entities.Student;
import com.courses.hibernateandjpa.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
@Slf4j
public class StudentRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory ;

    public Student findById(Long id) {
        return getEntityManager().find(Student.class,id)  ;
    }


    public void deleteById(Long id ) {
        var em = getEntityManager() ;
        var tr =  em.getTransaction() ;
        tr.begin();
        Student student = em.find(Student.class,id) ;
        em.remove(student);
        tr.commit();

    }
    public void findAll() {
        var em = getEntityManager() ;
        Query result = em.createQuery("SELECT c FROM Student c") ;
        log.info("SELECT c FROM Student c {}",result.getResultList());
    }
    public void findAllTypedQuery() {
        var em = getEntityManager() ;
        TypedQuery<Student> result = em.createQuery("SELECT c FROM Student c",Student.class) ;
        log.info("SELECT c FROM Student c {}",result.getResultList());
    }




    private EntityManager getEntityManager() {
        return  entityManagerFactory.createEntityManager() ;
    }



}
