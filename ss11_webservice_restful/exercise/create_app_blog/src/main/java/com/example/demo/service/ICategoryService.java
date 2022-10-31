package com.example.demo.service;

import com.example.demo.model.AppBlog;
import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void create(Category category);

    void remove(Category category);

    Category findById(int id);

    void update(Category category);

}
