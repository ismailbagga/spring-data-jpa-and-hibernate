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
public class Course {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id ;
    private String name ;
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private Set<Review> reviews ;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students ;




    public Course(String name) {
        this.name = name ;
    }
}
