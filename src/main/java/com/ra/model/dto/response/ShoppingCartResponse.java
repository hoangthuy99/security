package com.ra.model.dto.response;

import com.ra.model.entity.Products;
import com.ra.model.entity.ShoppingCart;
import com.ra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ShoppingCartResponse {
    private Integer shoppingCartId;
    private Products products;
    private User user;
    private Integer orderQuantity;
    public ShoppingCartResponse(ShoppingCart shoppingCart){
        this.shoppingCartId = shoppingCart.getShoppingCartId();
        this.products = shoppingCart.getProducts();
        this.user = shoppingCart.getUser();
        this.shoppingCartId = shoppingCart.getOrderQuantity();
    }
}
