package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.services.BookingService;
import case_study.furama_resort.common.FileService;
import case_study.furama_resort.services.CustomerService;


import java.util.*;

public class BookingServiceImpl implements BookingService {
    private final FileService fileService = new FileService();
    private final CustomerService customerService = new CustomerServiceImpl();
    private final String FILE_PATH = "src\\case_study\\furama_resort\\data\\booking.csv";
    private TreeSet<Booking> bookingSet = fileService.readBooking(FILE_PATH);

    public void readBooking() {
        bookingSet = fileService.readBooking(FILE_PATH);
    }

    public void writeBooking() {
        fileService.writeBooking(FILE_PATH, bookingSet);
    }

    public void addBooking(Booking booking) {
        readBooking();
        bookingSet.add(booking);
        writeBooking();
    }

    public void displayBooking() {
        readBooking();
        bookingSet.forEach(booking -> {
            System.out.println(booking.toString());
        });
    }

    public boolean containId(int id) {
        readBooking();
        for (Booking booking : bookingSet) {
            if (booking.getBookingId() == id) {
                return true;
            }
        }
        return false;
    }

    public int countFacility(String name) {
        readBooking();
        int count = 0;
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int month;
        for (Booking booking : bookingSet) {
            month = Integer.parseInt(booking.getStartDate().split("/")[1]);
            if (booking.getServiceName().equals(name) && month == currentMonth) {
                count++;
            }
        }
        return count;
    }


    public Set<Customer> getCustomerList(int year) {
        readBooking();
        Set<Customer> customers = new LinkedHashSet<>();
        int bookingYear;
        int customerId;
        for (Booking booking : bookingSet) {
            bookingYear = Integer.parseInt(booking.getStartDate().split("/")[2]);
            if (bookingYear == year) {
                customerId = booking.getCustomerId();
                Customer customer = customerService.get(customerId);
                customers.add(customer);
            }
        }
        return customers;
    }

    public Stack<Customer> getMonthlyCustomerList() {
        readBooking();
        Calendar cal = Calendar.getInstance();
        Stack<Customer> customers = new Stack<>();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentYear = cal.get(Calendar.YEAR);
        int month;
        int year;
        for (Booking booking : bookingSet) {
            month = Integer.parseInt(booking.getStartDate().split("/")[1]);
            year = Integer.parseInt(booking.getStartDate().split("/")[2]);
            if (month == currentMonth && year == currentYear) {
                Customer customer = customerService.get(booking.getCustomerId());
                customers.push(customer);
            }
        }
        return customers;
    }

}
