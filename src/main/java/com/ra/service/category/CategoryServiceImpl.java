package com.ra.service.category;

import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.entity.Category;
import com.ra.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Page<CategoryResponse> getAll(Pageable pageable) {
        // maper
        Sort sort=Sort.by("categoryName").ascending();
        Pageable pageableCustom= PageRequest.of(pageable.getPageNumber(),5,sort);
        Page<Category> categories = categoryRepository.findAll(pageableCustom);
        return categories.map(CategoryResponse::new);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category findByName(String categoryName) {
        List<Category> allCategories = categoryRepository.findAll();
        // Tìm kiếm Category theo tên
        for (Category category : allCategories) {
            if (category.getCategoryName().equals(categoryName)) {
                return category;
            }
        }
        // Trả về null nếu không tìm thấy
        return null;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
