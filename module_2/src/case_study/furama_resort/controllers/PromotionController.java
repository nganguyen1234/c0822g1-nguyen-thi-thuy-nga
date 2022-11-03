package case_study.furama_resort.controllers;

import case_study.furama_resort.services.PromotionService;
import case_study.furama_resort.services.impl_classes.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    private final Scanner scanner = new Scanner(System.in);
    private PromotionService promotionService = new PromotionServiceImpl();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayCustomerInAYear();
                    break;
            }

        } while (true);
    }

    private void displayCustomerInAYear() {
        System.out.println("Year:");
        int year = Integer.parseInt(scanner.nextLine());
        promotionService.displayCustomerInAYear(year);
    }
}
