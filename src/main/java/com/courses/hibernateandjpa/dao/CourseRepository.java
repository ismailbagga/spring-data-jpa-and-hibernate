package com.courses.hibernateandjpa.dao;

import com.courses.hibernateandjpa.entities.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
@Slf4j
public class CourseRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory ;

    public Course findById(Long id) {
        return getEntityManager().find(Course.class,id)  ;
    }


    public void deleteById(Long id ) {
        var em = getEntityManager() ;
        var tr =  em.getTransaction() ;
        tr.begin();
        Course course = em.find(Course.class,id) ;
        em.remove(course);
        tr.commit();

    }
    public void findAll() {
        var em = getEntityManager() ;
        Query result = em.createQuery("SELECT c FROM Course c") ;
        log.info("SELECT c FROM Course c {}",result.getResultList());
    }
    public void findAllTypedQuery() {
        var em = getEntityManager() ;
        TypedQuery<Course> result = em.createQuery("SELECT c FROM Course c",Course.class) ;
        log.info("SELECT c FROM Course c {}",result.getResultList());
    }




    private EntityManager getEntityManager() {
        return  entityManagerFactory.createEntityManager() ;
    }



}
