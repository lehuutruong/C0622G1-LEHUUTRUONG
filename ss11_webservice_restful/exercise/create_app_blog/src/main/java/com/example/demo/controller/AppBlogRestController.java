package com.example.demo.controller;

import com.example.demo.dto.AppBlogDto;
import com.example.demo.model.AppBlog;
import com.example.demo.model.Category;
import com.example.demo.service.impl.AppBlogService;
import com.example.demo.service.impl.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/home/v1")
public class AppBlogRestController {
    @Autowired
    private AppBlogService appBlogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<AppBlog>> getAppBlogList(Pageable pageable) {
        Page<AppBlog> appBlogList = appBlogService.findAll(pageable);
        if (appBlogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appBlogList.getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addAppBlog(@RequestBody AppBlogDto appBlogDto) {
        AppBlog appBlog = new AppBlog();
        BeanUtils.copyProperties(appBlogDto, appBlog);
        appBlogService.create(appBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppBlog> updateAppBlog(@PathVariable int id, @RequestBody AppBlogDto appBlogDto) {
        AppBlog currentAppBlog = appBlogService.findById(id);
        if (currentAppBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AppBlog appBlog = new AppBlog();
        BeanUtils.copyProperties(appBlogDto, appBlog);
        appBlogService.update(appBlog);
        return new ResponseEntity<>(currentAppBlog, HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<AppBlog>> getCategory(@PathVariable int id) {
        List<AppBlog> blogList = appBlogService.findListByCategoryId(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<AppBlog>> searchAppBlog(@RequestParam String author){
    List<AppBlog> searchAppBlog = appBlogService.findByAuthor(author);
    if (searchAppBlog==null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(searchAppBlog, HttpStatus.OK);
    }
}
