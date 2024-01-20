package com.ra.model.dto.response;

import com.ra.model.entity.Category;
import com.ra.model.entity.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CategoryResponse {
    private Long category_id;
    private String category_name;
    private String description;
    private Boolean status;
    public CategoryResponse(Category category) {
        this.category_id = category.getCategoryId();
        this.category_name = category.getCategoryName();
        this.description = category.getDescription();
        this.status = category.getStatus();
    }


}
