package case_study.furama_resort.controllers;

import case_study.furama_resort.common.ExceptionHandling;
import case_study.furama_resort.common.RegexCheck;
import case_study.furama_resort.models.Booking;
import case_study.furama_resort.services.impl_classes.BookingServiceImpl;
import case_study.furama_resort.services.impl_classes.CustomerServiceImpl;
import case_study.furama_resort.services.impl_classes.FacilityServiceImpl;

import java.text.ParseException;
import java.util.Scanner;

public class BookingController {
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final BookingServiceImpl bookingService = new BookingServiceImpl();
    private final Scanner scanner = new Scanner(System.in);
    private final RegexCheck regexCheck = new RegexCheck();
    private final ExceptionHandling exceptionHandling = new ExceptionHandling();

    public void displayMenu() throws ParseException {
        int choice;
        do {
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBooking();
                    break;
                case 2:
                    displayBookingList();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private void addBooking() throws ParseException {
        Booking booking = new Booking();
        System.out.println("Please complete the following information:");
        System.out.println("1. Booking ID:");
        boolean checkId;
        int id;
        do {
            id = exceptionHandling.enterPositiveInteger();
            checkId = bookingService.containId(id);
            if (checkId) {
                System.out.println("This ID has existed, please try again!!!");
            } else {
                booking.setBookingId(id);
            }
        } while (checkId);

        System.out.println("2. Start date(dd/mm/yyyy):");
        booking.setStartDate(exceptionHandling.enterDate());
        System.out.println("3. End date(dd/mm/yyyy)");
        booking.setEndDate(exceptionHandling.enterEndDate(booking.getStartDate()));
        chooseService(booking);
        chooseCustomer(booking);
        bookingService.addBooking(booking);
    }

    private void chooseService(Booking booking) {
        System.out.println("All services:");
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.displayAllFacilities();
        System.out.println("Service name:");
        String name;
        boolean isContain;
        do {
            name = regexCheck.enterServiceInfo();
            isContain = facilityService.containsServiceName(name);
            if (isContain) {
                booking.setServiceName(name);
            } else {
                System.out.println("Please enter valid service name!!");
            }
        } while (!isContain);
    }

    private void chooseCustomer(Booking booking) {
        customerService.displayCustomerList();
        int id;
        do {
            System.out.println("5. Customer ID:");
            id = exceptionHandling.enterPositiveInteger();
            if (customerService.containsId(id)) {
                booking.setCustomerId(id);
                return;
            }
            System.out.println("please enter valid ID");
        } while (true);
    }

    private void displayBookingList() {
        bookingService.displayBooking();
    }
}
