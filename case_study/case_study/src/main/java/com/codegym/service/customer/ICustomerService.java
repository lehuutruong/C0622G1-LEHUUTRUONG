package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
   List<Customer> findAll();
    void create(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    Page<Customer> search(String nameSearch, String email, String customerType, Pageable pageable);
}
