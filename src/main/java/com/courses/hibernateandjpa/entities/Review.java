package com.courses.hibernateandjpa.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Setter
@Getter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id  ;
    private String rating ;
    private String description  ;

    @ManyToOne()
    private Course course ;

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }
}
