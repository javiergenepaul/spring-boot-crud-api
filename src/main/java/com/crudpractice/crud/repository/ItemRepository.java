package com.crudpractice.crud.repository;

import com.crudpractice.crud.model.Item;
import com.crudpractice.crud.response.ItemListCustomQueryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT id, name, description, price FROM items", nativeQuery = true)
    Collection<ItemListCustomQueryResponse> getQuery();
}
