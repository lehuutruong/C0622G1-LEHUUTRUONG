package com.codegym.service.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    List<Facility> findAll();
    void create(Facility facility);

    Facility findById(int id);

    void update(Facility facility);

    Page<Facility> search(String nameSearch,String facilityType, Pageable pageable);
}
