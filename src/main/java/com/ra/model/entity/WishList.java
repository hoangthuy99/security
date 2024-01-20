package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishListId;
    //Todo: foreign key user id(done)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //todo: foreign key product id(done)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;
}
