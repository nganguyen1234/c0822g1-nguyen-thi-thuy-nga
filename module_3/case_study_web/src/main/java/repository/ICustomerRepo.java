package repository;

import model.customer.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerRepo {
    boolean addCustomer(Customer customer) throws SQLException;
     List<String> getAllCustomerType();
    List<Customer> getAllCustomer();
    boolean deleteCustomer(int id);
    boolean editCustomer(Customer customer);
}
