package com.example.service.impl;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import com.example.util.exception.DataDuplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean checkIdCardPresent(Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
//       case edit other fields
        if (customer1 != null) {
            if (customer.getIdCard().equals(customer1.getIdCard())) {
                return false;
            }
        }
//        other case(edit idCard field, add)
        return !customerRepository.findByIdCard(customer.getIdCard()).isEmpty();
    }

    @Override
    public boolean checkEmailPresent(Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
//       case edit other fields
        if (customer1 != null) {
            if (customer.getEmail().equals(customer1.getEmail())) {
                return false;
            }
        }
//        other case(edit email field, add)
        return !customerRepository.findByEmail(customer.getEmail()).isEmpty();
    }

    @Override
    public boolean checkPhoneNumberPresent(Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
//       case edit other fields
        if (customer1 != null) {
            if (customer.getPhoneNumber().equals(customer1.getPhoneNumber())) {
                return false;
            }
        }
//        other case(edit phoneNumber field, add)
        return !customerRepository.findByPhoneNumber(customer.getPhoneNumber()).isEmpty();
    }

    @Override
    public Page<Customer> searchName(String name, String email, int customerTypeId, Pageable pageable) {
        return customerRepository.searchName(name, email, customerTypeId, pageable);
    }

    @Override
    public Page<Customer> searchName(String name, String email, Pageable pageable) {
        return customerRepository.searchName(name, email, pageable);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public boolean addNewCustomer(Customer customer) throws DataDuplicationException {
        boolean checkId = checkIdCardPresent(customer);
        boolean checkPhoneNumber = checkPhoneNumberPresent(customer);
        boolean checkEmail = checkEmailPresent(customer);

        DataDuplicationException dataDuplicationException = new DataDuplicationException();

        if (checkId) {
            dataDuplicationException.getErrorMap().put("idCard", "số CMND bạn vừa nhập đã tồn tại");
        }
        if (checkEmail) {
            dataDuplicationException.getErrorMap().put("email", "Email bạn vừa nhập đã tồn tại");
        }
        if (checkPhoneNumber) {
            dataDuplicationException.getErrorMap().put("phoneNumber", "số điện thoại bạn vừa nhập đã tồn tại");
        }
        if (!dataDuplicationException.getErrorMap().isEmpty()) throw dataDuplicationException;
        try {
            customerRepository.save(customer);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean editCustomer(Customer customer) throws DataDuplicationException {
        if (!customerRepository.findById(customer.getId()).isPresent()) {
            return false;
        }
        boolean checkId = checkIdCardPresent(customer);
        boolean checkPhoneNumber = checkPhoneNumberPresent(customer);
        boolean checkEmail = checkEmailPresent(customer);

        DataDuplicationException dataDuplicationException = new DataDuplicationException();

        if (checkId) {
            dataDuplicationException.getErrorMap().put("idCard", "số CMND bạn vừa nhập đã tồn tại");
        }
        if (checkEmail) {
            dataDuplicationException.getErrorMap().put("email", "Email bạn vừa nhập đã tồn tại");
        }
        if (checkPhoneNumber) {
            dataDuplicationException.getErrorMap().put("phoneNumber", "số điện thoại bạn vừa nhập đã tồn tại");
        }
        if (!dataDuplicationException.getErrorMap().isEmpty()) throw dataDuplicationException;
        try {
            customerRepository.save(customer);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }
}
