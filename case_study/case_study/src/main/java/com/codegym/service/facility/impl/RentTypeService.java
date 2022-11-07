package com.codegym.service.facility.impl;

import com.codegym.model.facility.RentType;
import com.codegym.repository.facility.IRentTypeRepository;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @Override
    public List<RentType> finAll() {
        return iRentTypeRepository.findAll();
    }
}
