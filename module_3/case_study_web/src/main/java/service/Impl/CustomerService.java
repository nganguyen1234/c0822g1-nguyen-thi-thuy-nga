package service.Impl;

import common.RegexCheck;
import model.customer.Customer;
import repository.ICustomerRepo;
import repository.Impl.customer.CustomerRepo;
import service.ICustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepo customerRepo = new CustomerRepo();
    private RegexCheck regexCheck = new RegexCheck();

    @Override
    public List<Customer> searchCustomer(String searchName, String searchPhoneNumber, String searchEmail) {
        return customerRepo.searchCustomer(searchName,searchPhoneNumber,searchEmail);
    }

    @Override
    public Map<String, String> addCustomer(Customer customer) {
        Map<String, String> errorMap = new HashMap<>();
        if (!regexCheck.checkName(customer.getName())) {
            errorMap.put("name", "The first letter of your name should be capitalized, your name can't be blank and can't have numbers");
        }
        if (!regexCheck.checkEmail(customer.getEmail())) {
            errorMap.put("email", "please match the requested format, ex:abc123@gmail.com");
        }
        if (!regexCheck.checkPhoneNumber(customer.getPhoneNumber())) {
            errorMap.put("phoneNumber", "please match the requested format, ex: 090xxxxxxx; 091xxxxxxx ; (84)+90xxxxxxx ; (84)+91xxxxxxx ");
        }
        if (!regexCheck.checkIdCard(customer.getIdCard())) {
            errorMap.put("idCard", "please match the requested format, ex: 123456789; 12345678901");
        }
        if (errorMap.isEmpty()) {
            try {
                customerRepo.addCustomer(customer);
            }catch (Exception e){
//                if ()
//                e.getMessage().contains("email");
            }

        }
        return errorMap;
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
