package com.crudpractice.crud.controller;

import com.crudpractice.crud.response.ApiResponseHandler;
import com.crudpractice.crud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ApiResponseHandler getAll() {
        return ApiResponseHandler.builder()
                .Message("Item List")
                .IsSuccess(true)
                .Status(HttpStatus.OK.value())
                .Data(itemService.getItemList())
                .build();
    }
}
