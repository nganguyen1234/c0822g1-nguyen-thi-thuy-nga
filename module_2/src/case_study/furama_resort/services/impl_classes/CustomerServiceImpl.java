package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.services.CustomerService;
import case_study.furama_resort.common.FileService;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    private FileService fileService = new FileService();
    private LinkedList<Customer> customerList = fileService.readCustomer("src\\case_study\\furama_resort\\data\\customer.csv");
//ArrayList<Integer> customerIdList = new ArrayList<>();

    private void readCustomer() {
        customerList = fileService.readCustomer("src\\case_study\\furama_resort\\data\\customer.csv");
    }

    private void writeCustomer() {
        fileService.writeCustomer("src\\case_study\\furama_resort\\data\\customer.csv", customerList);
    }

    @Override
    public void addInformation(Customer customer) {
        readCustomer();
        customerList.add(customer);
        writeCustomer();
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
        readCustomer();
        return customerList.get(index);
    }

    @Override
    public int search(int customerId) {
        readCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId() == customerId) {
                return i;
            }
        }
        return -1;
    }

    //    @Override
    public void displayCustomerList() {
        readCustomer();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    public boolean containsId(int id) {
        readCustomer();
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == id) {
                return true;
            }
        }
        return false;
    }


}
