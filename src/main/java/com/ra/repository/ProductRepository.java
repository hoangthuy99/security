package com.ra.repository;

import com.ra.model.entity.Category;
import com.ra.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query("SELECT pro from Products pro WHERE pro.productName like %?1% ")
    List<Products> searchProductsByProductName(String keyword);
    List<Products> findAllByCategoryCategoryId(Long id);

}
