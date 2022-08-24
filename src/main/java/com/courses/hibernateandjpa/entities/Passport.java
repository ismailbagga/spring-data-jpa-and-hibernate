package com.courses.hibernateandjpa.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;

    private String number  ;

//    @OneToOne
//    private  Student student ;

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
