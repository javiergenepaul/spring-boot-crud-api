package com.crudpractice.crud.service;

import com.crudpractice.crud.model.Item;
import com.crudpractice.crud.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItemList() {
        return itemRepository.findAll();
    }
}
