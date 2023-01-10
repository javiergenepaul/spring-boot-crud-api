package com.crudpractice.crud.repository;

import com.crudpractice.crud.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
