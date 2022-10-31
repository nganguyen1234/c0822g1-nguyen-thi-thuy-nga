package case_study.furama_resort.controllers;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.services.impl_classes.BookingServiceImpl;
import case_study.furama_resort.services.impl_classes.CustomerServiceImpl;
import case_study.furama_resort.services.impl_classes.FacilityServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BookingController {
    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    private BookingServiceImpl bookingService = new BookingServiceImpl();
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
    public void displayMenu() throws ParseException {
        int choice;
        do {
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addBooking();
                    break;
                case 2:
                    break;

            }
        } while (true);
    }

    private void addBooking() throws ParseException {
        Booking booking = new Booking();
        System.out.println("Please complete the following information:");
        System.out.println("Booking ID:");
        booking.setBookingId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Start date(dd/mm/yyyy):");
        booking.setStartDate(simpleDateFormat.parse(scanner.nextLine()));
        System.out.println("End date(dd/mm/yyyy)");
        booking.setEndDate(simpleDateFormat.parse(scanner.nextLine()));
//        chooseFacility(booking);
//        chooseCustomer(booking);
    }

    private void chooseFacility(Booking booking) {
        System.out.println("Service Name");
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.displayAllFacilities();
        do {
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());
//           booking.setServiceName();
        } while (true);
    }

    private void chooseCustomer(Booking booking) {

        customerService.displayCustomerList();
        int id;
        do {
            System.out.println("Customer ID:");
            id = Integer.parseInt(scanner.nextLine());
            if (customerService.idContains(id)) {
                booking.setCustomerId(id);
                return;
            }
            System.out.println("please enter valid ID");
        } while (true);
}
}
