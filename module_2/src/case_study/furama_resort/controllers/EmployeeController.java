package case_study.furama_resort.controllers;

import case_study.furama_resort.services.impl_classes.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    public static void menu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        do {
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tDelete employee\n" +
                    "4\tEdit employee\n" +
                    "5\tReturn main menu\n");
            System.out.println("Enter your next choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.addInfor();
                    break;
                case 5:
                    return;
            }
        } while (choice != 5);
    }

}
