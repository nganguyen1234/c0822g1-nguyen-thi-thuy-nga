package oop_exercise.service.impl;

import oop_exercise.model.MotorBike;
import oop_exercise.service.TransportSerive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MotorBikeServiceImpl implements TransportSerive {
    MotorBike[] motorBikes = new MotorBike[100];
    Scanner scanner = new Scanner(System.in);
    int size = 0;

    @Override
    public void add() {
        MotorBike motorBike = new MotorBike();
        System.out.print("Nhập biển kiểm soát: ");
        motorBike.setLicensePlate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên hãng xe: ");
        motorBike.setCarCompany(scanner.nextLine());
        System.out.print("Nhập năm sản xuất xe:");
        motorBike.setManufacturingYear(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập tên chủ sở hữu:");
        motorBike.setOwnerName(scanner.nextLine());
        System.out.print("Nhập công suất của xe:");
        motorBike.setCapacity(Integer.parseInt(scanner.nextLine()));
        if (size >= motorBikes.length) {
            motorBikes = Arrays.copyOf(motorBikes, size + motorBikes.length / 2);
            motorBikes[size] = motorBike;
            size++;
        } else {
            motorBikes[size] = motorBike;
            size++;
        }
    }

    @Override
    public void remove() {
//        System.out.print("Nhập biển kiểm soát của phương tiện muốn xóa:");
//        int licensePlate = Integer.parseInt(scanner.nextLine());
//        for (MotorBike motorbike : motorBikes) {
//            if (motorbike.getLicensePlate() == licensePlate) {
//                motorBikes.remove(motorbike);
//            }
//        }
    }

    @Override
    public void find() {

    }
}
