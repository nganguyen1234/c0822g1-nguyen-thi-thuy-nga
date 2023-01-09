package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like concat('%',:name,'%') and email like concat('%',:email,'%') and customer_type_id = :customerTypeId and is_deleted=false", nativeQuery = true)
    Page<Customer> searchName(@Param("name") String name, @Param("email") String email, @Param("customerTypeId") int customerTypeId, Pageable pageable);
    @Query(value = "select * from customer where name like concat('%',:name,'%') and email like concat('%',:email,'%')and is_deleted=false", nativeQuery = true)
    Page<Customer> searchName(@Param("name") String name, @Param("email") String email, Pageable pageable);

    List<Customer> findByIdCard(String idCard);
    List<Customer> findByPhoneNumber(String phoneNumber);
    List<Customer> findByEmail(String email);
}
