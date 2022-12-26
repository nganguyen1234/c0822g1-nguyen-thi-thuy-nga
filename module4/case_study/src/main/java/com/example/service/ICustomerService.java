package com.example.service;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> searchName(String name,String email,String phoneNumber, Pageable pageable);
}
