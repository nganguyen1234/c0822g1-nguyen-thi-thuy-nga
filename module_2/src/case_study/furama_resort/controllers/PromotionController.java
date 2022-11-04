package case_study.furama_resort.controllers;

import case_study.furama_resort.common.ExceptionHandling;
import case_study.furama_resort.services.PromotionService;
import case_study.furama_resort.services.impl_classes.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    private final Scanner scanner = new Scanner(System.in);
    private PromotionService promotionService = new PromotionServiceImpl();
    private ExceptionHandling exceptionHandling = new ExceptionHandling();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n" +
                    "Enter your choice");
            choice = exceptionHandling.enterPositiveInteger();
            switch (choice) {
                case 1:
                    displayCustomerInAYear();
                    break;
                case 2:
                    displayVoucherList();
                    ;
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private void displayCustomerInAYear() {
        System.out.println("Year:");
        int year = exceptionHandling.enterPositiveInteger();
        promotionService.displayCustomerInAYear(year);
    }

    private void displayVoucherList() {
        promotionService.displayThisMonthCustomers();
        int voucher10;
        int voucher20;
        int voucher50;
        boolean check;
        do {
            System.out.println("Number of voucher 10%:");
            voucher10 = exceptionHandling.enterPositiveInteger();
            System.out.println("Number of voucher 20%:");
            voucher20 = exceptionHandling.enterPositiveInteger();
            System.out.println("Number of voucher 50%:");
            voucher50 = exceptionHandling.enterPositiveInteger();
            check = promotionService.displayPromotionList(voucher10, voucher20, voucher50);
        } while (!check);
    }
}
