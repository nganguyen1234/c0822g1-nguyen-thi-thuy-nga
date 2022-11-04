package case_study.furama_resort.controllers;

import case_study.furama_resort.common.ExceptionHandling;
import case_study.furama_resort.common.RegexCheck;
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
    private ExceptionHandling exceptionHandling = new ExceptionHandling();
    private RegexCheck regexCheck = new RegexCheck();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n");
            choice = exceptionHandling.enterPositiveInteger();
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
            choice = exceptionHandling.enterPositiveInteger();
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
            id = regexCheck.enterVillaInfo();
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
            name = regexCheck.enterServiceInfo();
            check = facilityService.containsServiceName(name);
            if (check) {
                System.out.println("This service name has existed, please enter new name");
            } else {
                villa.setServiceName(name);
            }
        } while (check);
        System.out.println("Area:");
        villa.setArea(exceptionHandling.enterArea());
        System.out.println("Room standard");
        villa.setRoomStandard(regexCheck.enterServiceInfo());
        System.out.println("Pool area:");
        villa.setPoolArea(exceptionHandling.enterArea());
        System.out.println("Cost:");
        villa.setCost(exceptionHandling.enterDouble());
        System.out.println("rental type");
        RentImpl.displayType();
        System.out.println("Enter your choice for rent type:");
        int choice;
        do {
            choice = exceptionHandling.enterPositiveInteger();
            if (choice > 3 || choice < 1) {
                System.out.println("Please enter the valid choice");
            }
        } while (choice > 3 || choice < 1);
        villa.setRent(RentImpl.types[choice - 1]);
        System.out.println("Number of people:");
        villa.setNumberOfPeople(exceptionHandling.enterNumberOfPeople());
        System.out.println("Number of floors:");
        villa.setNumberOfFloors(exceptionHandling.enterPositiveInteger());
        facilityService.addVillaInfo(villa);
    }

    private void addRoom() {
        Room room = new Room();
        System.out.println("Please complete the following information:");
        System.out.println("ID:");
        String id;
        do {
            id = regexCheck.enterRoomInfo();
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
            name = regexCheck.enterServiceInfo();
            check = facilityService.containsServiceName(name);
            if (check) {
                System.out.println("This service name has existed, please enter new name");
            } else {
                room.setServiceName(name);
            }
        } while (check);
        System.out.println("Area:");
        room.setArea(exceptionHandling.enterArea());
        System.out.println("Cost:");
        room.setCost(exceptionHandling.enterDouble());
        System.out.println("rental type");
        RentImpl.displayType();
        System.out.println("Enter your choice for rent type:");
        int choice;
        do {
            choice = exceptionHandling.enterPositiveInteger();
            if (choice > 3 || choice < 1) {
                System.out.println("Please enter the valid choice");
            }
        } while (choice > 3 || choice < 1);
        room.setRent(RentImpl.types[choice - 1]);
        System.out.println("Number of people:");
        room.setNumberOfPeople(exceptionHandling.enterNumberOfPeople());
        System.out.println("Complimentary service:");
        room.setComplimentaryService(scanner.nextLine());
        facilityService.addRoomInfo(room);
    }
}
