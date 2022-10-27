package case_study.furama_resort.controllers;

import case_study.furama_resort.models.Facility.Facility;
import case_study.furama_resort.models.Facility.Room;
import case_study.furama_resort.models.Facility.Villa;
import case_study.furama_resort.services.impl_classes.FacilityServiceImpl;
import case_study.furama_resort.services.impl_classes.RentImpl;

import java.util.Scanner;

public class FacilityController {
    private Scanner scanner = new Scanner(System.in);
    private FacilityServiceImpl facilityService = new FacilityServiceImpl();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayList();
                    break;
                case 2:
                    addFacility();
                    break;
                case 3:
                    displayMaintenance();
                    break;
                case 4:
                    return;
            }
        } while (choice > 4 || choice < 1);

    }

    private void displayList() {
        facilityService.display();
    }

    private void displayMaintenance() {
        facilityService.displayMaintenanceFacilities();
    }

    private void addFacility() {
        int choice;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New Room\n" +
                    "3.\tBack to menu\n");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addVilla();
                    break;
                case 2:
                    addRoom();
                    break;
                case 3:
                    return;
            }
        } while (true);

    }

    private void addVilla() {
        Villa villa = new Villa();
        System.out.println("Please complete the following information:");
        System.out.println("Area:");
        villa.setArea(Double.parseDouble(scanner.nextLine()));
        System.out.println("Cost:");
        villa.setCost(Double.parseDouble(scanner.nextLine()));
        System.out.println("rental type");
        RentImpl.displayType();
        System.out.println("Enter your choice for rent type:");
        int choice;
        do {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 3 || choice < 1) {
                System.out.println("Please enter the valid choice");
            }
        } while (choice > 3 || choice < 1);
        villa.setRent(RentImpl.types[choice - 1]);
        System.out.println("Number of people:");
        villa.setNumberOfPeople(Integer.parseInt(scanner.nextLine()));
        System.out.println("has used: ");
        int count = Integer.parseInt(scanner.nextLine());
        facilityService.addVillaInfo(villa, count);
    }

    private void addRoom() {
        Room room = new Room();
        System.out.println("Please complete the following information:");
        System.out.println("Area:");
        room.setArea(Double.parseDouble(scanner.nextLine()));
        System.out.println("Cost:");
        room.setCost(Double.parseDouble(scanner.nextLine()));
        System.out.println("rental type");
        RentImpl.displayType();
        System.out.println("Enter your choice for rent type:");
        int choice;
        do {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 3 || choice < 1) {
                System.out.println("Please enter the valid choice");
            }
        } while (choice > 3 || choice < 1);
        room.setRent(RentImpl.types[choice - 1]);
        System.out.println("Number of people:");
        room.setNumberOfPeople(Integer.parseInt(scanner.nextLine()));
        System.out.println("Complimentary Service:");
        room.setComplimentaryService(scanner.nextLine());
        System.out.println("has used: ");
        int count = Integer.parseInt(scanner.nextLine());
        facilityService.addRoomInfo(room, count);
    }
}
