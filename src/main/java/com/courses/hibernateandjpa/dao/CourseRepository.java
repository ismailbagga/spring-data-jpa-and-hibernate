package com.courses.hibernateandjpa.dao;

import com.courses.hibernateandjpa.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class CourseRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory ;

    public Course findById(Long id) {
        return getEntityManager().find(Course.class,id)  ;


    }





    private EntityManager getEntityManager() {
        return  entityManagerFactory.createEntityManager() ;
    }



}
