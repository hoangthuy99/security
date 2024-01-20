package com.ra.model.dto.response;

import com.ra.model.entity.OrderStatus;
import com.ra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponse {
    private Long order_id;
    private String serial_number;
    private User user;
    private Double total_price;
    private OrderStatus status;
    private String note;
    private String receive_name;
    private String receive_address;
    private String phone;
    private Date create_at;
    private Date received_at;
}
