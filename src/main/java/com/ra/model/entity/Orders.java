package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String serialNumber;
    //todo:foreign key user id(done)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double totalPrice;
    private OrderStatus status;
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String phone;
    private Date createAt;
    private Date receivedAt;

    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<OrderDetails> listOrderDetails;



}
