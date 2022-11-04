package case_study.furama_resort.services;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Person.Customer;

import java.util.Set;
import java.util.Stack;

public interface BookingService extends Service {
    void addBooking(Booking booking);
    void displayBooking();
    int countFacility(String name);
    Set<Customer> getCustomerList(int year);
    Stack<Customer> getMonthlyCustomerList();
    boolean containId(int id);
}
