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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;
//    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
//    @JsonBackReference
//    private Set<Student> students;

    @OneToMany(mappedBy = "student")
//    @JsonBackReference
    @JsonManagedReference
    private Set<CourseRegistration> registrations;
}
