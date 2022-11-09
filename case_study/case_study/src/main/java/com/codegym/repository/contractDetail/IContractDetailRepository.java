package com.codegym.repository.contractDetail;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value="select * from contract_detail where contract_id =:id",nativeQuery=true)
    List<ContractDetail> getListContractDetail(@Param("id") int id);

    @Query(value = "select * from `contract_detail` join `contract` on contract.id = contract_detail.contract_id join `customer` on contract.customer_id = customer.id where customer.id = :customerId",nativeQuery = true)
    List<ContractDetail> getListContractDetailByCustomerId(@Param("customerId") int id);
}
