package com.codegym.repository.contract;

import com.codegym.dto.CustomerHavingBooking;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from `contract` where delete_status= 1", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select * from `contract` where id=:id and delete_status = 1", nativeQuery = true)
    Optional<Contract> findById(@Param("id") int id);

    @Query(value = "select c.name customerName,ct.start_date startDate,ct.end_date endDate,c.id customerId,GROUP_CONCAT(f.name) as facilityList\n" +
            "    from `contract` ct join `customer` c on ct.customer_id=c.id \n" +
            "    join `facility` f on ct.facility_id=f.id \n" +
            "    group by c.name"
            ,countQuery ="select count(*) from(select c.name customerName,ct.start_date startDate,ct.end_date endDate,c.id customerId,GROUP_CONCAT(f.name) as facilityList\n" +
            "    from `contract` ct join `customer` c on ct.customer_id=c.id \n" +
            "    join `facility` f on ct.facility_id=f.id \n" +
            "    group by c.name) as tb"
            ,nativeQuery = true)
    Page<CustomerHavingBooking> useFacility(Pageable pageable);

}
