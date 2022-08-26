package com.courses.hibernateandjpa.repositories;

import com.courses.hibernateandjpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.core.CrudMethods;

public interface CourseSpringDataJpaRepo  extends JpaRepository<Course,Long> {
}
