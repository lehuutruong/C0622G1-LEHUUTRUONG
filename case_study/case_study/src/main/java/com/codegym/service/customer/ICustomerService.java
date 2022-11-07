package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void create(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    Page<Customer> search(String nameSearch, String email, String customerType, Pageable pageable);
}
