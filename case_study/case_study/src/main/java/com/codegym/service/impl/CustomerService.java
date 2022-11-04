package com.codegym.service.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Customer> findByNameAndEmailAndCustomerType(String name, String email, String customerTypeId, String status, Pageable pageable) {
        return iCustomerRepository.findByNameAndEmailAndCustomerTypeId(name,email,customerTypeId,status,pageable);
    }

    @Override
    public Page<Customer> findByNameAndEmail(String name, String email, String status, Pageable pageable) {
        return iCustomerRepository.findPageNameAndEmail(name,email,status,pageable);
    }

    @Override
    public Page<Customer> findByStatus(String status, Pageable pageable) {
        return iCustomerRepository.findPageStatus(status,pageable);
    }
}
