package com.crudpractice.crud.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;

    @ManyToMany
    @JoinTable(name = "employee_project",
        joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "empId")},
            inverseJoinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "projectId")}
    )
    private Set<Project> assignedProjects = new HashSet<>();
}
