package com.ra.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    private String productName;
    private String description;
    private Float unitPrice;
    @Min(0)
    private Integer stokeQuantity;
    private String image;
}
