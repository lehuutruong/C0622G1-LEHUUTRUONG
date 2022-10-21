package com.example.demo.repository;

import com.example.demo.model.AppBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppBlogRepository extends JpaRepository<AppBlog, Integer> {

}
