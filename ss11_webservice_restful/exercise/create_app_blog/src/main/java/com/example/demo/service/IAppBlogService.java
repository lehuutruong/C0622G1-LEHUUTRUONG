package com.example.demo.service;

import com.example.demo.model.AppBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IAppBlogService {
    Page<AppBlog> findAll(Pageable pageable);

    void create(AppBlog appBlog);

    void remove(AppBlog appBlog);

    AppBlog findById(int id);

    void update(AppBlog appBlog);

    List<AppBlog> findListByCategoryId(int id);
}
