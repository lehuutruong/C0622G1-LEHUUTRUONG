package com.example.demo.service.impl;

import com.example.demo.model.AppBlog;
import com.example.demo.repository.IAppBlogRepository;
import com.example.demo.service.IAppBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppBlogService implements IAppBlogService {
    @Autowired
    IAppBlogRepository iAppBlogRepository;

    @Override
    public List<AppBlog> findAll() {
        return iAppBlogRepository.findAll();
    }

    @Override
    public void create(AppBlog appBlog) {
        iAppBlogRepository.save(appBlog);
    }

    @Override
    public void remove(AppBlog appBlog) {
        iAppBlogRepository.delete(appBlog);
    }

    @Override
    public AppBlog findById(int id) {
        return iAppBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(AppBlog appBlog) {
        iAppBlogRepository.save(appBlog);
    }


}
