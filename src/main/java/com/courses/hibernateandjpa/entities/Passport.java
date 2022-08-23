package com.courses.hibernateandjpa.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue
    private Long id  ;

    private String number  ;

    public Passport(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport passport)) return false;
        return Objects.equals(id, passport.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
