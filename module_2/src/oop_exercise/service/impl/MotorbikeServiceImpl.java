package oop_exercise.service.impl;

import oop_exercise.model.MotorBike;
import oop_exercise.service.IMotorbikeService;

import java.util.Arrays;

public class MotorbikeServiceImpl implements IMotorbikeService {
    private MotorBike[] motorBikes = new MotorBike[100];
    private int size = 0;
    @Override
    public void add(MotorBike motorBike) {
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
    public boolean remove(int licensePlate) {
        int index = this.find(licensePlate);
        if (index != -1) {
            System.arraycopy(motorBikes, index + 1, motorBikes, index, size - 1 - index);
            motorBikes[size-1] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int find(int licensePlate) {
        for (int i = 0; i < size; i++) {
            if (motorBikes[i].getLicensePlate() == licensePlate) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display(int index) {
        System.out.println(motorBikes[index].toString());
    }

    @Override
    public void display() {
        for (int i = 0; i < size ; i++) {
            System.out.println(motorBikes[i].toString());
        }
    }
}
