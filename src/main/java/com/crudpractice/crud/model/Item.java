package com.crudpractice.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @DecimalMin(value = "0.0")
    private double price;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name= "tags_id", nullable = false)
    private Tag tags;
}
