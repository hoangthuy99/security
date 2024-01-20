package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_code")
    private String productCode;
    private String productName;
    private String description;
    @Column(name = "unit_price")
    private Float unitPrice;
    private Integer stokeQuantity;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Date createAt;
    private Date updateAt;

    @OneToMany(mappedBy = "products")
    @JsonIgnore
    private List<OrderDetails> listOrderDetails;

    @OneToMany(mappedBy = "products")
    @JsonIgnore
    private List<ShoppingCart> listShoppingCart;

    @OneToMany(mappedBy = "products")
    @JsonIgnore
    private List<WishList> listWishList;

}
