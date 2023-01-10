package com.crudpractice.crud.controller;

import com.crudpractice.crud.dto.ItemDto;
import com.crudpractice.crud.model.Item;
import com.crudpractice.crud.repository.ItemRepository;
import com.crudpractice.crud.response.ApiResponseHandler;
import com.crudpractice.crud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ApiResponseHandler getAll() {
        return ApiResponseHandler.builder()
                .Message("item list")
                .IsSuccess(true)
                .Status(HttpStatus.OK.value())
                .Data(itemService.getItemList())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponseHandler getItem(@PathVariable Long id) {
        return ApiResponseHandler.builder()
                .Message("item details")
                .IsSuccess(true)
                .Status(HttpStatus.OK.value())
                .Data(itemService.getItemById(id))
                .build();
    }

    @PostMapping("/add")
    public ApiResponseHandler addItem(@RequestBody ItemDto item){
        return ApiResponseHandler.builder()
                .Message("added item successfully")
                .IsSuccess(true)
                .Status(HttpStatus.OK.value())
                .Data(itemService.saveItem(item))
                .build();
    }

    @PutMapping("/update/{id}")
    public ApiResponseHandler updateItem(@PathVariable Long id, @RequestBody ItemDto item) {
        return ApiResponseHandler.builder()
                .Message("update item successfully")
                .IsSuccess(true)
                .Status(HttpStatus.OK.value())
                .Data(itemService.updateItem(id, item))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponseHandler deleteItem(@PathVariable Long id) {
        return ApiResponseHandler.builder()
                .Message("delete item successfully")
                .IsSuccess(true)
                .Status(HttpStatus.OK.value())
                .Data(itemService.deleteProduct(id))
                .build();
    }
}
