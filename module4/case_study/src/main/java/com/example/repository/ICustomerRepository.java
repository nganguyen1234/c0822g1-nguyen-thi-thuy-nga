package com.example.repository;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like concat('%',:name,'%') and email like concat('%',:email,'%') and phone_number like concat('%',:phoneNumber,'%') and is_deleted=false", nativeQuery = true)
    Page<Customer> searchName(@Param("name") String name, @Param("email") String email, @Param("phoneNumber") String phoneNumber, Pageable pageable);

    Customer findByIdCard(String idCard);
}
