package com.courses.hibernateandjpa.repositories;

import com.courses.hibernateandjpa.entities.Course;
import com.courses.hibernateandjpa.entities.Passport;
import com.courses.hibernateandjpa.entities.Review;
import com.courses.hibernateandjpa.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Repository("repo")
@Slf4j
public class CourseRepository {
    @Autowired
    EntityManagerFactory entityManagerFactory ;

    @Transactional
    public  void saveCourse() {
        Course course = new Course("Spring Boot") ;
        var em =   getEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }
    public void  saveCourseWithMultipleReviews() {
//        Course course = new Course("Spring Boot") ;
        Review r1 = new Review("5","best course ever") ;
        Review r2 = new Review("5","spring part was awesome") ;
        Review r3 = new Review("4","h2 database was hard to understand") ;
        var em  = getEntityManager() ;
        em.getTransaction().begin();
        Course course = em.find(Course.class,1L) ;

        r1.setCourse(course);
        r2.setCourse(course);
        r3.setCourse(course);
        em.persist(r1);
        em.persist(r2);
        em.persist(r3);

        // this won't give review course id if if i set on course cascade to persist
//        course.setReviews(Set.of(r1,r2,r3));

        em.getTransaction().commit();

    }
    public void  saveMore() {
        var em  = getEntityManager() ;
        em.getTransaction().begin();
        Course course = em.find(Course.class,1L) ;
        log.info("Some Stuff here");
        log.info("course -> {}",course);
        log.info("More Stuff");
        log.info("course reviews-> {}",course.getReviews());
//        em.persist(course);
        em.getTransaction().commit() ;
    }
    public  void getPassportWithStudent() {
        var em = getEntityManager() ;
        em.getTransaction().begin();
        Passport passport = em.find(Passport.class,1L) ;
        log.info("passport -> {}",passport);
        log.info("Pausing ...");
        log.info("student of passport -> {}",passport.getStudent());

        em.getTransaction().commit();



    }
    public void studentLazyFetch() {
        var em  = getEntityManager() ;

        em.getTransaction().begin();
        var student = em.find(Student.class,1L) ;
        log.info("student -> {}",student);
        log.info("student passport -> {}",student.getPassport());
        log.info("student passport again -> {}",student.getPassport());
        em.getTransaction().commit();}


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
