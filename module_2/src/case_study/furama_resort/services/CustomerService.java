package case_study.furama_resort.services;

import case_study.furama_resort.models.Person.Customer;

public interface CustomerService extends Service<Customer> {
    void addInformation(Customer customer);
    int search(int id);
    Customer get(int id);
    void displayCustomerList();
    boolean containsId(int id);
}
