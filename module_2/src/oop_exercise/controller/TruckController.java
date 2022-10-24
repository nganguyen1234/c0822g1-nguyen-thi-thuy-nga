package oop_exercise.controller;

import oop_exercise.model.Truck;
import oop_exercise.service.impl.CarManufacturerImpl;
import oop_exercise.service.impl.TruckServiceImpl;

import java.util.Scanner;

public class TruckController {
    private final TruckServiceImpl truckService = new TruckServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void add() {
        Truck truck = new Truck();
        System.out.print("Nhập biển kiểm soát: ");
        truck.setLicensePlate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Chọn hãng xe: ");
        int choice;
        do {
            CarManufacturerImpl.display();
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 5 || choice < 1) {
                System.out.println("Vui lòng chọn đúng hãng xe theo hệ thống cung cấp");
            }
        } while (choice > 5 || choice < 1);
        truck.setCarManufacturer(CarManufacturerImpl.carManufacturers[choice - 1]);
        System.out.print("Nhập năm sản xuất xe:");
        truck.setManufacturingYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên chủ sở hữu:");
        truck.setOwnerName(scanner.nextLine());
        System.out.print("Nhập trọng tải của xe:");
        truck.setLoad(Integer.parseInt(scanner.nextLine()));
        this.truckService.add(truck);
    }

    public void remove(int licensePlate) {
        int choice;
        if (this.truckService.find(licensePlate) != -1) {
            do {
                System.out.println("Bạn xác nhận xóa thông tin xe tải với biển kiểm soát " + licensePlate + "??\n" +
                        "1.\tYes\n" +
                        "2.\tNo");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 2 || choice < 1) {
                    System.out.println("!!!!Vui lòng nhập đúng lựa chọn hệ thống cung cấp");
                }
            } while (choice > 2 || choice < 1);
            switch (choice) {
                case 1:
                    truckService.remove(licensePlate);
                    System.out.println("Đã xóa thành công");
                case 2:
                    break;
            }
        }
    }

    public void find(int licensePlate) {
        int index = truckService.find(licensePlate);
        if (index != -1) {
            truckService.display(index);
        }
    }
    public void display(){
        truckService.display();
    }
}
