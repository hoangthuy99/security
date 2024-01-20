package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.model.dto.response.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String fullName;
    //Tên đăng nhập không được trùng
    @Column(unique = true)
    private String username;
    private String password;
    private Status status;
    private String avatar;
    private String phone;
    private String address;
    //Tìm hiểu thêm eager và lazy
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Address> listAddress;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Orders> listOrders;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ShoppingCart> listShoppingCart;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<WishList> listWishList;
}
