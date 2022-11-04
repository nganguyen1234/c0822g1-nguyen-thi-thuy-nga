package case_study.furama_resort.services.impl_classes;

import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.services.BookingService;
import case_study.furama_resort.services.PromotionService;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    BookingService bookingService = new BookingServiceImpl();
    Set<Customer> customers;


    public void displayCustomerInAYear(int year) {
        customers = bookingService.getCustomerList(year);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void displayThisMonthCustomers() {
        Stack<Customer> customers = bookingService.getMonthlyCustomerList();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public boolean displayPromotionList(int voucher10, int voucher20, int voucher50) {
        Stack<Customer> customers = bookingService.getMonthlyCustomerList();
        if (customers.size() != (voucher10 + voucher20 + voucher50)) {
            System.out.println("enter valid number of vouchers");
            return false;
        }
        Map<String, Integer> vouchers = new HashMap<>();
        Queue<String> voucherList = new LinkedList<>();
        vouchers.put("10%", voucher10);
        vouchers.put("20%", voucher20);
        vouchers.put("50%", voucher50);
        for (String key : vouchers.keySet()) {
            for (int i = 0; i < vouchers.get(key); i++) {
                voucherList.add(key);
            }
        }
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.pop() + " voucher: " + voucherList.remove());
            i--;
        }
        return true;
    }

}
