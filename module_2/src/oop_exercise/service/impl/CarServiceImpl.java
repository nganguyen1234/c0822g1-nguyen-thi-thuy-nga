package oop_exercise.service.impl;

import oop_exercise.model.Car;
import oop_exercise.service.TransportSerive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarServiceImpl implements TransportSerive {
    Car[] cars = new Car[100];
    Scanner scanner = new Scanner(System.in);
int size = 0;
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
        if (size >= cars.length) {
            cars = Arrays.copyOf(cars, size + cars.length / 2);
            cars[size] = car;
            size++;
        }else {
            cars[size] = car;
            size++;
        }
    }

    @Override
    public void remove() {

    }

    @Override
    public void find() {

    }
}
