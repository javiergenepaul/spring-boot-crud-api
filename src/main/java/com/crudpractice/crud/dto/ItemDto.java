package com.crudpractice.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    @NotBlank(message = "required field")
    @Size(max = 10, message = "max of 10 char")
    private String name;
    @NotBlank
    @Size(max = 50)

    private String description;
//    @DecimalMax("10.0")
    @DecimalMin("10.0")
    private double price;

}
