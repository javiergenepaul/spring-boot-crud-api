package com.crudpractice.crud.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
public interface ItemListCustomQueryResponse {
    Long getId();
    String getName();
    String getDescription();
    double getPrice();
}
