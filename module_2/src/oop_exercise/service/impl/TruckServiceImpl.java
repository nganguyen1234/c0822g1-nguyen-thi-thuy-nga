package oop_exercise.service.impl;

import oop_exercise.model.Truck;
import oop_exercise.service.TransportSerive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TruckServiceImpl implements TransportSerive {
    Truck[] trucks = new Truck[100];
    Scanner scanner = new Scanner(System.in);
    int size = 0;

    @Override
    public void add() {
        Truck truck = new Truck();
        System.out.print("Nhập biển kiểm soát: ");
        truck.setLicensePlate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên hãng xe: ");
        truck.setCarCompany(scanner.nextLine());
        System.out.print("Nhập năm sản xuất xe:");
        truck.setManufacturingYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên chủ sở hữu:");
        truck.setOwnerName(scanner.nextLine());
        System.out.print("Nhập trọng tải của xe:");
        truck.setLoad(Integer.parseInt(scanner.nextLine()));
        if (size >= trucks.length) {
            trucks = Arrays.copyOf(trucks, size + trucks.length / 2);
            trucks[++size] = truck;
        }else {
            trucks[size] = truck;
        }

    }

    @Override
    public void remove() {

    }

    @Override
    public void find() {

    }
}
