package case_study.furama_resort.controllers;


import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.models.Person.CustomerType;
import case_study.furama_resort.services.impl_classes.CustomerServiceImpl;
import case_study.furama_resort.services.impl_classes.CustomerTypeImpl;

import java.util.Scanner;

public class CustomerController {
    private final Scanner scanner = new Scanner(System.in);
    private CustomerServiceImpl customerService = new CustomerServiceImpl();

    public void displayMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n");
            System.out.println("Enter your next choice:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.display();
                    break;
                case 2:
                    this.add();
                    break;
                case 3:
                    this.edit();
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    private void add() {
        Customer customer = new Customer();
        System.out.println("Please complete the following information");
        int id;
        do {
            System.out.println("ID");
            id = Integer.parseInt(scanner.nextLine());
            if (customerService.containsId(id)) {
                System.out.println("This ID has existed, please enter new ID");
            } else {
                customer.setCustomerId(id);
            }
        } while (customerService.containsId(id));

        System.out.println("Name");
        customer.setName(scanner.nextLine());
        System.out.println("Date of birth:");
        customer.setDateOfBirth(Integer.parseInt(scanner.nextLine()));
        System.out.println("Gender");
        customer.setGender(scanner.nextLine());
        System.out.println("Citizen Identity Number");
        customer.setCitizenIdentityNumber(Integer.parseInt(scanner.nextLine()));
        System.out.println("Phone number");
        customer.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
        System.out.println("Email address:");
        customer.setEmail(scanner.nextLine());
        System.out.println("Address:");
        customer.setAddress(scanner.nextLine());
        System.out.println("Customer type:");
        int choice;
        do {
            int i = 1;
            for (CustomerType type : CustomerTypeImpl.customerTypes) {
                System.out.println(i++ + " " + type.toString());
            }
            System.out.println("Enter your choice");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 5 || choice < 1) {
                System.out.println("Please enter valid level");
            }
        } while (choice > 5 || choice < 1);
        customer.setCustomerType(CustomerTypeImpl.customerTypes[choice - 1]);
        customerService.addInformation(customer);
    }

    private void edit() {
        System.out.println("Enter ID of the customer that you want to edit:");
        int id = Integer.parseInt(scanner.nextLine());
        int index = customerService.search(id);
        if (index != -1) {
            int choice;
            Customer customer = customerService.get(id);
            do {
                System.out.println("1.\tEdit Name\n" +
                        "2.\tEdit date of birth\n" +
                        "3.\tEdit gender\n" +
                        "4.\tEdit citizen identity number\n" +
                        "5.\tEdit phone number\n" +
                        "6.\tEdit email address\n" +
                        "7.\tEdit address\n" +
                        "8.\tEdit customer type\n" +
                        "9.\tExit\n" +
                        "**Enter your choice:**");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 9 || choice < 1) {
                    System.out.println("!!!!!Please enter valid choice");
                }
                switch (choice) {
                    case 1:
                        System.out.println("New name:");
                        customer.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("New date of birth:");
                        customer.setDateOfBirth(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("New gender");
                        customer.setGender(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("New Citizen Identity Number");
                        customer.setCitizenIdentityNumber(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("New phone number");
                        customer.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 6:
                        System.out.println("New email address:");
                        customer.setEmail(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("New Address:");
                        customer.setAddress(scanner.nextLine());
                        break;
                    case 8:
                        System.out.println("New customer type:");
                        int choice2;
                        do {
                            int i = 1;
                            for (CustomerType level : CustomerTypeImpl.customerTypes) {
                                System.out.println(i++ + " " + level.toString());
                            }
                            System.out.println("Enter your choice");
                            choice2 = Integer.parseInt(scanner.nextLine());
                            if (choice2 > 5 || choice2 < 1) {
                                System.out.println("Please enter valid level");
                            }
                        } while (choice2 > 5 || choice2 < 1);
                        customer.setCustomerType(CustomerTypeImpl.customerTypes[choice2 - 1]);
                        break;
                    case 9:
                        break;
                }
            } while (choice < 9);
        } else {
            System.out.println("ID is not found!!!");
        }
    }

    private void display() {
        customerService.displayCustomerList();
    }
}
