package repository;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepo {
    boolean addCustomer(Customer customer);
     List<String> getAllCustomerType();
    List<Customer> getAllCustomer();
    boolean deleteCustomer(int id);
    boolean editCustomer(Customer customer);
}
