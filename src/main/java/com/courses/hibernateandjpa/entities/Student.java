package com.courses.hibernateandjpa.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

