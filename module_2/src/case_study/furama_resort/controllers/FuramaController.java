package case_study.furama_resort.controllers;

import java.text.ParseException;
import java.util.Scanner;

public class FuramaController {
    public void displayMainMenu() throws ParseException {
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();
        FacilityController facilityController = new FacilityController();
        BookingController bookingController = new BookingController();
        PromotionController promotionController = new PromotionController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===========Menu===========");
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeController.displayMenu();
                    break;
                case 2:
                    customerController.displayMenu();
                    break;
                case 3:
                    facilityController.displayMenu();
                    break;
                case 4:
                    bookingController.displayMenu();
                    break;
                case 5:
                    promotionController.displayMenu();
                    break;
                case 6:
                    System.exit(6);
            }
        } while (choice != 6);

    }
}
