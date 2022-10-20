package oop_extra_exercise.service.impl;

import oop_extra_exercise.model.MotorBike;
import oop_extra_exercise.model.Transport;
import oop_extra_exercise.model.Truck;
import oop_extra_exercise.service.TransportSerive;

import java.util.ArrayList;
import java.util.Scanner;

public class TruckServiceImpl implements TransportSerive {
    ArrayList<Truck> trucks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
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
        trucks.add(truck);
    }

    @Override
    public void remove() {

    }

    @Override
    public void find() {

    }
}
