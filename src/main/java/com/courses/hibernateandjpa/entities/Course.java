package com.courses.hibernateandjpa.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter()
@Setter()
public class Course {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id ;
    private String name ;
    public Course(String name) {
        this.name = name ;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
