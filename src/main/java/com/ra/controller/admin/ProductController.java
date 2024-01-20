package com.ra.controller.admin;

import com.ra.model.dto.request.Product;
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
@RequestMapping("/v1/admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Value("${path-upload}")
    private String pathUpload;

    @GetMapping("")
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<ProductResponse> products = productService.getAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Products product) {
        Products products = productService.save(product);
        return new ResponseEntity<>(products, HttpStatus.CREATED);
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

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProductInfo(
            @PathVariable Long productId,
            @RequestBody Products updatedProduct) {
        // Kiểm tra xem sản phẩm có tồn tại hay không
        Optional<Products> productOptional = productService.findByID(productId);
        if (productOptional.isPresent()) {
            Products existingProduct = productOptional.get();
            // Cập nhật thông tin sản phẩm
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setUnitPrice(updatedProduct.getUnitPrice());
            productService.save(existingProduct);

            return new ResponseEntity<>("Thông tin sản phẩm đã được cập nhật.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sản phẩm không tồn tại.", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/delete/{productId}")
    public ResponseEntity<?> delete(@PathVariable Long productId){
       productService.delete(productId);
       return new ResponseEntity<>(HttpStatus.OK);
    }


}
