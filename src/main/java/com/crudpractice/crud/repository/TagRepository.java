package com.crudpractice.crud.repository;

import com.crudpractice.crud.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
