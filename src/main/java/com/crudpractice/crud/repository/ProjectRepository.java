package com.crudpractice.crud.repository;

import com.crudpractice.crud.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
