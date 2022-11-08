package com.codegym.service.contractDetail.impl;

import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contractDetail.IContractDetailRepository;
import com.codegym.service.contractDetail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }
}
