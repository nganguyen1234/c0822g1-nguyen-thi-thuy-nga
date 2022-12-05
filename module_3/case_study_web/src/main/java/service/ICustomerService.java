package service;

import model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    boolean addCustomer(Customer customer);
    List<String> getAllCustomerType();
}
