package com.crudpractice.crud.service;

import com.crudpractice.crud.dto.ItemDto;
import com.crudpractice.crud.model.Item;
import com.crudpractice.crud.repository.ItemRepository;
import com.crudpractice.crud.response.ItemListCustomQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    public Item saveItem(ItemDto itemDto) {
        Item item = Item.builder()
                .name(itemDto.getName())
                .description(itemDto.getDescription())
                .price(itemDto.getPrice())
                .tags(itemDto.getTags())
                .build();
        return itemRepository.save(item);
    }

    public Item updateItem(long id, ItemDto itemDto) {
        Item itemSelected = itemRepository.findById(id).orElse(null);
        Item item = itemSelected.builder()
                .name(itemDto.getName())
                .description(itemDto.getDescription())
                .price(itemDto.getPrice())
                .build();
        return itemRepository.save(itemSelected);
    }

    public Item deleteProduct(long id) {
        Item itemSelected = itemRepository.findById(id).orElse(null);
        itemRepository.deleteById(id);
        return itemSelected;
    }

    public Collection<?> getAllItemByQuery() {
        return itemRepository.getQuery();
    }
}
