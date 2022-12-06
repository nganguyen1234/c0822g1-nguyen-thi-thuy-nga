package service.Impl;

import model.customer.Customer;
import repository.ICustomerRepo;
import repository.Impl.CustomerRepo;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepo customerRepo = new CustomerRepo();

    @Override
    public boolean addCustomer(Customer customer) {
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
