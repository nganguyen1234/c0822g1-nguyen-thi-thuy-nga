package oop_exercise.service.impl;

import oop_exercise.model.Car;
import oop_exercise.service.TransportSerive;

import java.util.ArrayList;
import java.util.Scanner;

public class CarServiceImpl implements TransportSerive {
    ArrayList<Car> cars = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        Car car = new Car();
        System.out.print("Nhập biển kiểm soát: ");
        car.setLicensePlate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên hãng xe: ");
        car.setCarCompany(scanner.nextLine());
        System.out.print("Nhập năm sản xuất xe:");
        car.setManufacturingYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên chủ sở hữu:");
        car.setOwnerName(scanner.nextLine());
        System.out.print("Nhập số chỗ ngồi của xe:");
        car.setNumberOfSeat(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập kiểu xe:");
        car.setOwnerName(scanner.nextLine());
        cars.add(car);
    }

    @Override
    public void remove() {

    }

    @Override
    public void find() {

    }
}
