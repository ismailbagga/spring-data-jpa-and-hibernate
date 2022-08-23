package com.courses.hibernateandjpa.dao;

import com.courses.hibernateandjpa.entities.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class CourseRepository {
    private Logger log = LoggerFactory.getLogger(CourseRepository.class)  ;
    @Autowired
    EntityManagerFactory entityManagerFactory ;
//    @Autowired EntityManager em ;

    public Course findById(Long id) {
        return getEntityManager().find(Course.class,id)  ;
    }


    public void deleteById(Long id ) {
        var em = getEntityManager() ;
        var tr =  em.getTransaction() ;
        tr.begin();
        Course course = em.find(Course.class,id) ;
        em.remove(course);
        tr.commit(); ;

    }

    public void playWithEntityManager() {
        log.info("Playing Around with Entity manager");

        var em = getEntityManager() ;
        var tr =  em.getTransaction() ;
        tr.begin();
        var course1 = new Course("Spring Data JPA") ;
        em.persist(course1) ;
        var course2 = new Course("Angular Js") ;
        em.persist(course2) ;
//        em.flush();
//        em.detach(course2);
        course1.setName(" Jpa Essentials");
        course2.setName("Angular");
        em.refresh(course2);
        tr.commit();


    }



    private EntityManager getEntityManager() {
        return  entityManagerFactory.createEntityManager() ;
    }




}
