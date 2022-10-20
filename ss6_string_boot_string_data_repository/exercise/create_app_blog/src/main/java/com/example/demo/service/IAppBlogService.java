package com.example.demo.service;

import com.example.demo.model.AppBlog;

import java.util.List;
import java.util.Optional;

public interface IAppBlogService {
    List<AppBlog> findAll();

    void create(AppBlog appBlog);

    void remove(AppBlog appBlog);

     AppBlog findById(int id);

     void update(AppBlog appBlog);
}
