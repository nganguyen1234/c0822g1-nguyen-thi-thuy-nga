package oop_extra_exercise.service.impl;

import oop_extra_exercise.model.MotorBike;
import oop_extra_exercise.service.TransportSerive;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MotorBikeServiceImpl implements TransportSerive {
    ArrayList<MotorBike> motorBikes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

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
        motorBikes.add(motorBike);
    }

    @Override
    public void remove() {
        System.out.print("Nhập biển kiểm soát của phương tiện muốn xóa:");
        int licensePlate = Integer.parseInt(scanner.nextLine());
        for (MotorBike motorbike: motorBikes) {
            if (motorbike.getLicensePlate() == licensePlate ){
                motorBikes.remove(motorbike);
            }
        }
    }

    @Override
    public void find() {

    }
}
