package com.example.service.customer;

import com.example.model.customer.Customer;
import com.example.util.exception.DataDuplicationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    boolean checkIdCardPresent(Customer customer);

    boolean checkEmailPresent(Customer customer);

    boolean checkPhoneNumberPresent(Customer customer);

    Page<Customer> searchName(String name, String email, int customerTypeId, Pageable pageable);

    Page<Customer> searchName(String name, String email, Pageable pageable);

    List<Customer> getAllCustomer();

    boolean addNewCustomer(Customer customer) throws DataDuplicationException;

    boolean editCustomer(Customer customer) throws DataDuplicationException;

    boolean deleteCustomer(Customer customer);

    Customer findById(int id);
}
