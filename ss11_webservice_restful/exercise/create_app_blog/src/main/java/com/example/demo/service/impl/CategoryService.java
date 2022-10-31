package com.example.demo.service.impl;

import com.example.demo.model.AppBlog;
import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void create(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(Category category) {
        iCategoryRepository.delete(category);
    }

    @Override
    public Category findById(int id) {
        Category category = iCategoryRepository.findById(id).orElse(new Category());
        Optional<Category> optionalCategory = iCategoryRepository.findById(id);
        if ((optionalCategory.isPresent())) {
            category = optionalCategory.get();
        }
        return category;
    }

    @Override
    public void update(Category category) {
        iCategoryRepository.save(category);
    }

}
