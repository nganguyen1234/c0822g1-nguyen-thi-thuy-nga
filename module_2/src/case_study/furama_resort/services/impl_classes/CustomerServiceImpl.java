package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.services.CustomerService;
import java.util.LinkedList;

public class CustomerServiceImpl implements CustomerService {
    LinkedList<Customer> customerList = new LinkedList<>();


    @Override
    public void addInformation(Customer customer) {
        customerList.add(customer);
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

    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }
}
