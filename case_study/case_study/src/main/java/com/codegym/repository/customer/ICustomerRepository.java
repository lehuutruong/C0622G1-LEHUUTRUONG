package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select c.* from `customer` c inner join `customer_type` ct " +
            "on c.customer_type_id = ct.id " +
            "where c.name like %:name% and c.email like %:email% and ct.name like %:type% and c.delete_status= 1", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerTypeId(@Param("name") String nameSearch,
                                                     @Param("email") String email,
                                                     @Param("type") String customerType,
                                                     Pageable pageable);
    @Query(value="select customer.name,contract.start_date,contract.end_date,facility.name from customer join contract on contract.customer_id=customer.id \n" +
            "                       join facility on contract.facility_id=facility.id\n" +
            "                       where year(end_date)>=2022 and month(end_date)>=9 and day(end_date)>=11",nativeQuery=true)
    List<Customer> findUserFacility();
}
