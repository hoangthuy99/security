package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;
    @Column(unique = true,name = "category_name")
    private String categoryName;
    private String description;
    @Column(columnDefinition = "bit default 1")
    private Boolean status ;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    List<Products> products;
}
