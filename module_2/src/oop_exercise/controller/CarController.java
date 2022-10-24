package oop_exercise.controller;

import oop_exercise.model.Car;
import oop_exercise.service.impl.CarManufacturerImpl;
import oop_exercise.service.impl.CarServiceImpl;

import java.util.Scanner;

public class CarController {
    private CarServiceImpl carService = new CarServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void add() {
        Car car = new Car();
        System.out.print("Nhập biển kiểm soát: ");
        car.setLicensePlate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Chọn hãng xe: ");
        int choice;
        do {
            CarManufacturerImpl.display();
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 5 || choice < 1) {
                System.out.println("Vui lòng chọn đúng hãng xe theo hệ thống cung cấp");
            }
        } while (choice > 5 || choice < 1);
        car.setCarManufacturer(CarManufacturerImpl.carManufacturers[choice - 1]);
        System.out.print("Nhập năm sản xuất xe:");
        car.setManufacturingYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên chủ sở hữu:");
        car.setOwnerName(scanner.nextLine());
        System.out.print("Nhập số chỗ ngồi của xe:");
        car.setNumberOfSeat(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập kiểu xe:");
        car.setOwnerName(scanner.nextLine());
        carService.add(car);
    }

    public void remove(int licensePlate) {
        int choice;
        if (this.carService.find(licensePlate) != -1) {
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
                    carService.remove(licensePlate);
                    System.out.println("Đã xóa thành công");
                case 2:
                    break;
            }
        }
    }

    public void find(int licensePlate) {
        int index2 = carService.find(licensePlate);
        if (index2 != -1) {
            carService.display(index2);
        }
    }

    public void display() {
        carService.display();
    }
}
