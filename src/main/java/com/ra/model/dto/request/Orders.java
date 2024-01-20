package com.ra.model.dto.request;

import com.ra.model.entity.OrderStatus;
import com.ra.model.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Orders {
    private String serial_number;
    @NotNull(message = "Không được rỗng")
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
