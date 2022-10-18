package com.using_thymeleaf_fo_product_management_app.repository.impl;

import com.using_thymeleaf_fo_product_management_app.model.Product;
import com.using_thymeleaf_fo_product_management_app.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productList;

    static {
        productList = new LinkedHashMap<>();
        productList.put(1, new Product(1, "cake", 12, "DN"));
        productList.put(2, new Product(2, "car", 20, "VN"));
        productList.put(3, new Product(3, "sugar", 30, "LAO"));
        productList.put(4, new Product(4, "computer", 70, "CAM"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product item : productList.values()) {
            if (item.getName().contains(name)) {
                products.add(item);
            }
        }
        return products;
    }
}
