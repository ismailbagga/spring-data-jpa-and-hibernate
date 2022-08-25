package com.courses.hibernateandjpa.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString()
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ToString.Exclude
  @OneToOne(mappedBy = "student")
  private Passport passport ;

  @ManyToMany()
  @JoinTable(
          name = "courses_taught", // table name
          // Array of column from this side of entity      attribute          name in table
          joinColumns = @JoinColumn(referencedColumnName = "id",name = "student_enrolled_id") ,
          // Array of columns from entity associated with
          inverseJoinColumns = @JoinColumn(referencedColumnName = "id",name = "course_taught_id")
          // And more features


  )
  @ToString.Exclude
  private List<Course> courses = new ArrayList<>() ;

  public Student(String name) {
    this.name = name;
  }

  public Student(String name , Passport passport) {
    this.name = name;
    this.passport = passport ;
  }
}

