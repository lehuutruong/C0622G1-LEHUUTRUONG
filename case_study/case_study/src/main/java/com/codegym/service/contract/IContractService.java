package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Optional<Contract> findById(int id);

}
