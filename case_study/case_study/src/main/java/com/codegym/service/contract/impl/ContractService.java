package com.codegym.service.contract.impl;

import com.codegym.dto.CustomerHavingBooking;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;
import com.codegym.repository.attachFacility.IAttachFacilityRepository;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.repository.contractDetail.IContractDetailRepository;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.service.contract.IContractService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public Contract findById(int id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public List<AttachFacility> getAttachFacilities() {
        return iAttachFacilityRepository.findAll();
    }

    @Override
    public List<ContractDetail> getListContractDetail() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> getContractDetail(int id) {
        return iContractDetailRepository.getListContractDetail(id);
    }

    @Override
    public void create(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public List<ContractDetail> getContractDetailByCustomer(int id) {
        return iContractDetailRepository.getListContractDetailByCustomerId(id);
    }

    @Override
    public Page<CustomerHavingBooking> useFacility(Pageable pageable) {
        return iContractRepository.useFacility(pageable);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }
}
