package com.ra.controller.auth;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Products;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/auth/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Value("${path-upload}")
    private String pathUpload;
    @GetMapping("")
    public ResponseEntity<?> getAll(Pageable pageable){
        Page<ProductResponse> products = productService.getAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Products product){
        Products products = productService.save(product);
        return new ResponseEntity<>(products,HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Products> getProductById(@PathVariable Long productId) {
        // Kiểm tra xem sản phẩm có tồn tại hay không
        Optional<Products> productOptional = productService.findByID(productId);
        if (productOptional.isPresent()) {
            Products products = productOptional.get();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
