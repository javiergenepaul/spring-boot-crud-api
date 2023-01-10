package com.crudpractice.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "tags", cascade = CascadeType.ALL)
    private Set<Item> item;
    private String tag;
    private boolean status;
}
