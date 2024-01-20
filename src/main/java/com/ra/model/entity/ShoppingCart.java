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
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shoppingCartId;
    //Todo: Product Id foreign Key(done)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;
    //Todo: User Id foreign Key(done)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Integer orderQuantity;
}
