package service.Impl;

import model.customer.Customer;
import repository.ICustomerRepo;
import repository.Impl.customer.CustomerRepo;
import service.ICustomerService;

import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    ICustomerRepo customerRepo = new CustomerRepo();

    @Override
    public Map<String,String> addCustomer(Customer customer) {
        return customerRepo.addCustomer(customer);
    }

    @Override
    public List<String> getAllCustomerType() {
        return customerRepo.getAllCustomerType();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepo.getAllCustomer();
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepo.deleteCustomer(id);
    }

    @Override
    public boolean editCustomer(Customer customer) {
        return customerRepo.editCustomer(customer);
    }
}
