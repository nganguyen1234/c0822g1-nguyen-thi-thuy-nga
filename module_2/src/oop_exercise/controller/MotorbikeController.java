package oop_exercise.controller;

import oop_exercise.model.MotorBike;
import oop_exercise.service.impl.CarManufacturerImpl;
import oop_exercise.service.impl.MotorbikeServiceImpl;

import java.util.Scanner;

public class MotorbikeController {
    private MotorbikeServiceImpl motorbikeService = new MotorbikeServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void add() {
        MotorBike motorBike = new MotorBike();
        System.out.print("Nhập biển kiểm soát: ");
        motorBike.setLicensePlate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Chọn hãng xe: ");
        int choice;
        do {
            CarManufacturerImpl.display();
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 5 || choice < 1) {
                System.out.println("Vui lòng chọn đúng hãng xe theo hệ thống cung cấp");
            }
        } while (choice > 5 || choice < 1);
        motorBike.setCarManufacturer(CarManufacturerImpl.carManufacturers[choice - 1]);
        System.out.print("Nhập năm sản xuất xe:");
        motorBike.setManufacturingYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên chủ sở hữu:");
        motorBike.setOwnerName(scanner.nextLine());
        System.out.print("Nhập công suất của xe:");
        motorBike.setCapacity(Integer.parseInt(scanner.nextLine()));
        motorbikeService.add(motorBike);
    }

    public void remove(int licensePlate) {
        int choice;
        if (motorbikeService.find(licensePlate) != -1) {
            do {
                System.out.println("Bạn xác nhận xóa thông tin xe ô tô với biển kiểm soát " + licensePlate + "??\n" +
                        "1.\tYes\n" +
                        "2.\tNo");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 2 || choice < 1) {
                    System.out.println("!!!!Vui lòng nhập đúng lựa chọn hệ thống cung cấp");
                }
            } while (choice > 2 || choice < 1);
            switch (choice) {
                case 1:
                    motorbikeService.remove(licensePlate);
                    System.out.println("Đã xóa thành công");
                case 2:
                    break;
            }
        }
    }

    public void find(int licensePlate) {
        int index3 = motorbikeService.find(licensePlate);
        if (index3 != -1) {
            motorbikeService.display(index3);
        }

    }

    public void display() {
        motorbikeService.display();
    }
}
