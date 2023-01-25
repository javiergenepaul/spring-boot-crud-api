package com.crudpractice.crud.repository;

import com.crudpractice.crud.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
