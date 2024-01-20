package com.ra.service.product;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<ProductResponse> getAll(Pageable pageable);
    Products save(Products products);
    Optional<Products> findByID(Long id);
    List<Products> searchProductByName(String keyword);
    List<Products> findByCategory(Long category);
    List<Products> findAllNew();

    void delete(Long id);
}
