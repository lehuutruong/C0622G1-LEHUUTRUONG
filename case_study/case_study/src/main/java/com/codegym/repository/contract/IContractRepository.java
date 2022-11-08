package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value = "select * from `contract` where delete_status= 1", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select * from `contract` where id=:id and delete_status = 1", nativeQuery = true)
    Optional<Contract> findById(@Param("id") int id);
}
