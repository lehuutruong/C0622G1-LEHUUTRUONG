package com.example.demo.repository;

import com.example.demo.model.AppBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IAppBlogRepository extends JpaRepository<AppBlog, Integer> {
    @Modifying
    @Transactional
    @Query(value= "SELECT * FROM app_blog WHERE category_id = :keyword", nativeQuery=true)
    List<AppBlog> findByCategoryId(@Param("keyword") int categoryId);
}
