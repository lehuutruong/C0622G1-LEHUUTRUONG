package com.codegym.service;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void create(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerTypeId, String status, Pageable pageable);

    Page<Customer> findByNameAndEmail(String name, String email, String status, Pageable pageable);

    Page<Customer> findByStatus(String status, Pageable pageable);
}
