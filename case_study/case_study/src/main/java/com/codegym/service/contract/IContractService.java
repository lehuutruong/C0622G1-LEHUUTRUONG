package com.codegym.service.contract;

import com.codegym.dto.CustomerHavingBooking;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Contract findById(int id);

    List<AttachFacility> getAttachFacilities();

    List<ContractDetail> getListContractDetail();

    void saveContractDetail(ContractDetail contractDetail);


    List<ContractDetail> getContractDetail(int contractId);

    void create(Contract contract);

    List<Contract> findAll();

    List<ContractDetail> getContractDetailByCustomer(int id);

    Page<CustomerHavingBooking> useFacility(Pageable pageable);
}
