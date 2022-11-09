package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        Customer customer = iCustomerRepository.findById(id).orElse(new Customer());
        Optional<Customer> optionalCustomer = iCustomerRepository.findById(id);
        if ((optionalCustomer.isPresent())) {
            customer = optionalCustomer.get();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> search(String nameSearch, String email, String customerType, Pageable pageable) {
        return iCustomerRepository.findByNameAndEmailAndCustomerTypeId(nameSearch,email,customerType,pageable);
    }

    @Override
    public List<Customer> getCustomer() {
        return iCustomerRepository.findAll();
    }
   }
