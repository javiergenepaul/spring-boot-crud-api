package com.crudpractice.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String name;
//    private int age;
//    private String dept;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "student_course_table",
//            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")}
//    )
//    private Set<Course> courses;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private Set<CourseRegistration> registrations;
}
