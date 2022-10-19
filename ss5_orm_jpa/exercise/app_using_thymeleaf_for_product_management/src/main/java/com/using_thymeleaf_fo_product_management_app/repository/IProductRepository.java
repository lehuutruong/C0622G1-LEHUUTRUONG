package com.using_thymeleaf_fo_product_management_app.repository;

import com.using_thymeleaf_fo_product_management_app.model.Product;

import java.util.List;

public interface IProductRepository {
       List<Product> findAll();
       void save(Product product);
       void update(int id,Product product);
       void remove(Product product);
       Product findById(int id);
       List<Product> findByName(String name);
}
