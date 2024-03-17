package case_study.furama_resort.controllers;


import case_study.furama_resort.common.ExceptionHandling;
import case_study.furama_resort.common.RegexCheck;
import case_study.furama_resort.models.Person.Customer;
import case_study.furama_resort.models.Person.CustomerType;
import case_study.furama_resort.services.impl_classes.CustomerServiceImpl;
import case_study.furama_resort.services.impl_classes.CustomerTypeImpl;

import java.util.Scanner;

public class CustomerController {
    private final Scanner scanner = new Scanner(System.in);
    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final ExceptionHandling exceptionHandling = new ExceptionHandling();
    private RegexCheck regexCheck = new RegexCheck();

    public void displayMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n");
            System.out.println("Enter your next choice:");
            choice = exceptionHandling.enterPositiveInteger();
            scanner.next();
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
            id = exceptionHandling.enterPositiveInteger();
            if (customerService.containsId(id)) {
                System.out.println("This ID has existed, please enter new ID");
            } else {
                customer.setCustomerId(id);
            }
        } while (customerService.containsId(id));

        System.out.println("Name");
        customer.setName(regexCheck.enterWord());
        System.out.println("Date of birth:");
        customer.setDateOfBirth(exceptionHandling.enterDateOfBirth());
        System.out.println("Gender");
        customer.setGender(regexCheck.enterWord());
        System.out.println("Citizen Identity Number");
        customer.setCitizenIdentityNumber(exceptionHandling.enterPositiveInteger());
        System.out.println("Phone number");
        customer.setPhoneNumber(exceptionHandling.enterPositiveInteger());
        System.out.println("Email address:");
        customer.setEmail(regexCheck.enterEmail());
        System.out.println("Address:");
        customer.setAddress(regexCheck.enterWord());
        System.out.println("Customer type:");
        int choice;
        do {
            int i = 1;
            for (CustomerType type : CustomerTypeImpl.customerTypes) {
                System.out.println(i++ + " " + type.toString());
            }
            System.out.println("Enter your choice");
            choice = exceptionHandling.enterPositiveInteger();
            if (choice > 5 || choice < 1) {
                System.out.println("Please enter valid level");
            }
        } while (choice > 5 || choice < 1);
        customer.setCustomerType(CustomerTypeImpl.customerTypes[choice - 1]);
        customerService.addInformation(customer);
    }

    private void edit() {
        System.out.println("Enter ID of the customer that you want to edit:");
        int id = exceptionHandling.enterPositiveInteger();
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
                choice = exceptionHandling.enterPositiveInteger();
                if (choice > 9 || choice < 1) {
                    System.out.println("!!!!!Please enter valid choice");
                }
                switch (choice) {
                    case 1:
                        System.out.println("New name:");
                        customer.setName(regexCheck.enterWord());
                        break;
                    case 2:
                        System.out.println("New date of birth:");
                        customer.setDateOfBirth(exceptionHandling.enterDateOfBirth());
                        break;
                    case 3:
                        System.out.println("New gender");
                        customer.setGender(regexCheck.enterWord());
                        break;
                    case 4:
                        System.out.println("New Citizen Identity Number");
                        customer.setCitizenIdentityNumber(exceptionHandling.enterPositiveInteger());
                        break;
                    case 5:
                        System.out.println("New phone number");
                        customer.setPhoneNumber(exceptionHandling.enterPositiveInteger());
                        break;
                    case 6:
                        System.out.println("New email address:");
                        customer.setEmail(regexCheck.enterEmail());
                        break;
                    case 7:
                        System.out.println("New Address:");
                        customer.setAddress(regexCheck.enterWord());
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
                            choice2 = exceptionHandling.enterPositiveInteger();
                            if (choice2 > 5 || choice2 < 1) {
                                System.out.println("Please enter valid level");
                            }
                        } while (choice2 > 5 || choice2 < 1);
                        customer.setCustomerType(CustomerTypeImpl.customerTypes[choice2 - 1]);
                        break;
                    case 9:
                        break;
                }
                customerService.writeCustomer();
            } while (choice < 9);
        } else {
            System.out.println("ID is not found!!!");
        }
    }

    private void display() {
        customerService.displayCustomerList();
    }
}
