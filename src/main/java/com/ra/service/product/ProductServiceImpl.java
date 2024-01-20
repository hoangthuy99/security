package com.ra.service.product;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Products;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        Sort sort=Sort.by("productName").ascending();
        Pageable pageableCustom= PageRequest.of(pageable.getPageNumber(),5,sort);
        Page<Products> products = productRepository.findAll(pageableCustom);
        return products.map(ProductResponse::new);

    }

    @Override
    public List<Products> findAllNew() {
        List<Products> products = productRepository.findAll();
        products.sort(Comparator.comparingLong(Products::getProductId).reversed());
        return products;
    }

    @Override
    public Products save(Products products) {
        return productRepository.save(products);
    }

    @Override
    public Optional<Products> findByID(Long id) {
        return productRepository.findById(id);
    }


    @Override
    public List<Products> searchProductByName(String keyword) {
        return productRepository.searchProductsByProductName(keyword);
    }

    @Override
    public List<Products> findByCategory(Long category) {
        return productRepository.findAllByCategoryCategoryId(category);
    }


    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
