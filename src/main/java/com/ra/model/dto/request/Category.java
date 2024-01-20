package com.ra.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Category {
    @NotNull(message = "Không được rỗng")
    @NotEmpty(message = "Không được để trống")
    @NotBlank(message = "Không được bỏ rỗng")
    private String categoryName;
    private String description;
    private Boolean status;
}
