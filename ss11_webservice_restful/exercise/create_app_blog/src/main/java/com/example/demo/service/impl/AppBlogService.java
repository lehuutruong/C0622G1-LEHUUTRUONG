package com.example.demo.service.impl;

import com.example.demo.model.AppBlog;
import com.example.demo.repository.IAppBlogRepository;
import com.example.demo.service.IAppBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppBlogService implements IAppBlogService {
    @Autowired
    IAppBlogRepository iAppBlogRepository;

    @Override
    public Page<AppBlog> findAll(Pageable pageable) {
        return iAppBlogRepository.findAll(pageable);
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
        AppBlog appBlog =iAppBlogRepository.findById(id).orElse(new AppBlog());
        Optional<AppBlog> optionalAppBlog=iAppBlogRepository.findById(id);
        if ((optionalAppBlog.isPresent())){
            appBlog=optionalAppBlog.get();
        }
        return appBlog;
    }

    @Override
    public void update(AppBlog appBlog) {
        iAppBlogRepository.save(appBlog);
    }

    @Override
    public List<AppBlog> findListByCategoryId(int id) {
        return iAppBlogRepository.findByCategoryId(id);
    }

    @Override
    public List<AppBlog> findByAuthor(String author) {
        return iAppBlogRepository.findByAuthorContains(author);
    }
}
