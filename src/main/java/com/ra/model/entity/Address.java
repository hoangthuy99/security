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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    //todo: foreign key user id(done)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String full_address;
    private String phone;
    private String receive_name;

}
