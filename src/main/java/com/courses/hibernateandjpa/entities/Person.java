package com.courses.hibernateandjpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id ;

    public Person(String name, String location, LocalDate birthData) {
        this.name = name;
        this.location = location;
        this.birthData = birthData;
    }

    private String name ;
    private String location ;
    private LocalDate birthData ;

}
