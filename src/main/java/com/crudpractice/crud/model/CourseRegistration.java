package com.crudpractice.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistration {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    @JsonBackReference
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonBackReference
    private Course course;
//    @CreatedDate
//    private Date created_at;
//    @LastModifiedDate
//    private Date updated_at;
}
