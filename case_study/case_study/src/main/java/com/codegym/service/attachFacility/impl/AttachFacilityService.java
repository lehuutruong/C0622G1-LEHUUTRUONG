package com.codegym.service.attachFacility.impl;

import com.codegym.model.contract.AttachFacility;
import com.codegym.repository.attachFacility.IAttachFacilityRepository;
import com.codegym.service.attachFacility.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public AttachFacility findAttachFacilityId(int attachId) {
        return iAttachFacilityRepository.findById(attachId).orElse(null);
    }
}
