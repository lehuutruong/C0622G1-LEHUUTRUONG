package com.codegym.repository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where customer.name like %:name% and customer.email like %:email% and customer_type_id =:customerTypeId and customer.status =:delete_status", nativeQuery=true)
    Page<Customer> findByNameAndEmailAndCustomerTypeId(@Param("name") String name,
                                                       @Param("email") String email,
                                                       @Param("deleteStatus") String deleteStatus,
                                                       @Param("customerTypeList") String customerTypeList,
                                                       Pageable pageable);

    @Query(value = "select * from customer where name like %:name% and email like %:email% and customer.status =:delete_status", nativeQuery=true)
    Page<Customer> findPageNameAndEmail(@Param("name") String name,
                                        @Param("email") String email,
                                        @Param("deleteStatus") String deleteStatus,
                                        Pageable pageable);

    @Query(value = "select * from customer where customer.status =:delete_status", nativeQuery=true)
    Page<Customer> findPageStatus(@Param("deleteStatus") String deleteStatus,
                                  Pageable pageable);
}
