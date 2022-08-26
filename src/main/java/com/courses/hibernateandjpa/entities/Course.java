package com.courses.hibernateandjpa.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "Course") // change name of table that entity mapped to by default entity <Name> mapped to <name> table
//// ! letter case of name in table is automatically transifred ex = name='CourseDetails' mapped to table course_details table
@Entity
@NoArgsConstructor
@Getter()
@Setter()
@Cacheable(value = true)
public class Course {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private Set<Review> reviews ;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students ;


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Course(String name) {
        this.name = name ;
    }
}
