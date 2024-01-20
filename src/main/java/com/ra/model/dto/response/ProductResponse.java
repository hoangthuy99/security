package com.ra.model.dto.response;

import com.ra.model.entity.Category;
import com.ra.model.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ProductResponse {
    private Long product_id;
    private String product_code;
    private String productName;
    private String description;
    private Float unit_price;
    private Integer stokeQuantity;
    private String image;
    public ProductResponse(Products products) {
        this.product_id = products.getProductId();
        this.product_code = products.getProductCode();
        this.productName = products.getProductName();
        this.description = products.getDescription();
        this.unit_price = products.getUnitPrice();
        this.stokeQuantity = products.getStokeQuantity();
        this.image = products.getImage();
    }
}
