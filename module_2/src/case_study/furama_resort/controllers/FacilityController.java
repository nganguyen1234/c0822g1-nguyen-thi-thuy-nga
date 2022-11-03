package case_study.furama_resort.controllers;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Facility.Room;
import case_study.furama_resort.models.Facility.Villa;
import case_study.furama_resort.services.impl_classes.BookingServiceImpl;
import case_study.furama_resort.services.impl_classes.FacilityServiceImpl;
import case_study.furama_resort.services.impl_classes.RentImpl;

import java.util.Scanner;

public class FacilityController {
    private Scanner scanner = new Scanner(System.in);
    private FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private BookingServiceImpl bookingService = new BookingServiceImpl();

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
                    this.displayList();
                    break;
                case 2:
                    this.addFacility();
                    break;
                case 3:
                    this.displayMaintenance();
                    break;
                case 4:
                    return;
            }
        } while (true);

    }

    private void displayList() {
        facilityService.displayAllFacilities();
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
        System.out.println("ID:");
        String id;
        do {
            id = scanner.nextLine();
            if (facilityService.containsServiceId(id)) {
                System.out.println("This ID has existed, please enter new ID");
            } else {
                villa.setServiceId(id);
                break;
            }
        } while (true);
        System.out.println("Name:");
        String name;
        boolean check;
        do {
            name = scanner.nextLine();
            check = facilityService.containsServiceName(name);
            if (check) {
                System.out.println("This service name has existed, please enter new name");
            } else {
                villa.setServiceName(name);
            }
        } while (check);
        System.out.println("Area:");
        villa.setArea(Double.parseDouble(scanner.nextLine()));
        System.out.println("Type of room");
        villa.setTypeOfRoom(scanner.nextLine());
        System.out.println("Pool area:");
        villa.setPoolArea(Double.parseDouble(scanner.nextLine()));
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
        System.out.println("Number of floors:");
        villa.setNumberOfFloors(Integer.parseInt(scanner.nextLine()));
        facilityService.addVillaInfo(villa);
    }

    private void addRoom() {
        Room room = new Room();
        System.out.println("Please complete the following information:");
        System.out.println("ID:");
        String id;
        do {
            id = scanner.nextLine();
            if (facilityService.containsServiceId(id)) {
                System.out.println("This ID has existed, please enter new ID");
            } else {
                room.setServiceId(id);
                break;
            }
        } while (true);
        System.out.println("Name:");
        String name;
        boolean check;
        do {
            name = scanner.nextLine();
            check = facilityService.containsServiceName(name);
            if (check) {
                System.out.println("This service name has existed, please enter new name");
            } else {
                room.setServiceName(name);
            }
        } while (check);
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
        facilityService.addRoomInfo(room);
    }
}
