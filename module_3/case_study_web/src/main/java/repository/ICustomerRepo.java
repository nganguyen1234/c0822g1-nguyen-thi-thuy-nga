package repository;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepo {
    boolean addCustomer(Customer customer);
     List<String> getAllCustomerType();
}
