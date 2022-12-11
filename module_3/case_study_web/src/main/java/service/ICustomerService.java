package service;

import model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> searchCustomer(String searchName, String searchPhoneNumber, String searchEmail);
    Map<String,String> addCustomer(Customer customer);
    List<String> getAllCustomerType();
    List<Customer> getAllCustomer();
    boolean deleteCustomer(int id);
    boolean editCustomer(Customer customer);
}
