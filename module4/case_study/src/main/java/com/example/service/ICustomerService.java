package com.example.service;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> searchName(String name,String email,String phoneNumber, Pageable pageable);
    boolean addNewCustomer(Customer customer);
    boolean editCustomer(Customer customer);
    Customer findById(int id);
}
