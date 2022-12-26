package com.example.service.impl;

import com.example.model.customer.Customer;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> searchName(String name, String email, String phoneNumber, Pageable pageable) {
        return customerRepository.searchName(name, email, phoneNumber, pageable);
    }

    @Override
    public boolean addNewCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }
}