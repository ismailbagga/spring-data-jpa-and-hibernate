package com.courses.hibernateandjpa.repositories ;

import com.courses.hibernateandjpa.entities.Passport;
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


    public void  saveStudentWithPassport() {
        Passport passport = new Passport("2156") ;
        Student student = new Student("Jamie") ;
        student.setPassport(passport);
        var em  = getEntityManager() ;
        em.getTransaction().begin();

        em.persist(passport);
        em.persist(student) ;

        em.getTransaction().commit();

     }
     public void studentLazyFetch() {
         var em  = getEntityManager() ;

         em.getTransaction().begin();
         var student = em.find(Student.class,1L) ;
         log.info("student -> {}",student);
         log.info("student passport -> {}",student.getPassport());
         log.info("student passport again -> {}",student.getPassport());
         em.getTransaction().commit();


     }


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

