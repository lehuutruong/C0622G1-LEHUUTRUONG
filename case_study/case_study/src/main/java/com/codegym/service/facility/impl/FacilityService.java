package com.codegym.service.facility.impl;

import com.codegym.model.facility.Facility;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository iFacilityRepository;
    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public void create(Facility facility) {
     iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {
        Facility facility = iFacilityRepository.findById(id).orElse(new Facility());
        Optional<Facility> optionalFacility = iFacilityRepository.findById(id);
        if ((optionalFacility.isPresent())) {
            facility = optionalFacility.get();
        }
        return facility;
    }

    @Override
    public void update(Facility facility) {
    iFacilityRepository.save(facility);
    }

    @Override
    public Page<Facility> search(String nameSearch, String facilityType, Pageable pageable) {
        return iFacilityRepository.findByNameCustomerTypeId(nameSearch,facilityType,pageable);
    }
}
