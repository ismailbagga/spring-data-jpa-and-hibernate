package com.courses.hibernateandjpa.entities;

import lombok.*;

import javax.persistence.*;

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
  @OneToOne
  private Passport passport ;

  public Student(String name) {
    this.name = name;
  }

  public Student(String name , Passport passport) {
    this.name = name;
    this.passport = passport ;
  }
}

