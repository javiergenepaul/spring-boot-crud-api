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

    public Item getItemById(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(long id, Item item) {
        Item itemSelected = itemRepository.findById(id).orElse(null);
        itemSelected.setName(item.getName());
        itemSelected.setDescription(item.getDescription());
        itemSelected.setPrice(item.getPrice());
        return itemRepository.save(itemSelected);
    }

    public Item deleteProduct(long id) {
        Item itemSelected = itemRepository.findById(id).orElse(null);
        itemRepository.deleteById(id);
        return itemSelected;
    }
}
