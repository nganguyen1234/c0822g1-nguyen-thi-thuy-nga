package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.services.CustomerService;
import common.FileService;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    private FileService fileService = new FileService();
    LinkedList<Customer> customerList = fileService.readCustomer("src\\case_study\\furama_resort\\data\\customer.csv");
//ArrayList<Integer> customerIdList = new ArrayList<>();

    @Override
    public void addInformation(Customer customer) {
        customerList.add(customer);
        fileService.writeCustomer("src\\case_study\\furama_resort\\data\\customer.csv",customerList);
//        customerIdList.add(customer.getCustomerId());
    }
//    public boolean deleteInformation(int customerId, boolean choice) {
//        int index = this.search(customerId);
//        if (choice){
//            return customerList.remove(customerList.get(index));
//        }
//        return false;
//    }

    public Customer get(int index) {
        return customerList.get(index);
    }

    @Override
    public int search(int customerId) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId() == customerId) {
                return i;
            }
        }
        return -1;
    }

    //    @Override
    public void displayCustomerList() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    public boolean idContains(int id) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == id) {
                return true;
            }
        }
        return false;
    }


}
