package com.example.demo.service.impl;

import com.example.demo.model.Admin;
import com.example.demo.repository.IAdminRepository;
import com.example.demo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService implements IAdminService {
    @Autowired
    IAdminRepository iAdminRepository;
    @Override
    public List<Admin> findAll() {
        return iAdminRepository.findAll();
    }
}
