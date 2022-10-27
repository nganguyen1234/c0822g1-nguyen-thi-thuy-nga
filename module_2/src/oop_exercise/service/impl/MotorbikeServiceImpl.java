package oop_exercise.service.impl;

import oop_exercise.model.Motorbike;
import oop_exercise.service.IMotorbikeService;

import java.util.Arrays;

public class MotorbikeServiceImpl implements IMotorbikeService {
    private Motorbike[] motorbikes = new Motorbike[100];
    private int size = 0;
    @Override
    public void add(Motorbike motorBike) {
        if (size >= motorbikes.length) {
            motorbikes = Arrays.copyOf(motorbikes, size + motorbikes.length / 2);
            motorbikes[size] = motorBike;
            size++;
        } else {
            motorbikes[size] = motorBike;
            size++;
        }
    }

    @Override
    public boolean remove(int licensePlate) {
        int index = this.find(licensePlate);
        if (index != -1) {
            System.arraycopy(motorbikes, index + 1, motorbikes, index, size - 1 - index);
            motorbikes[size-1] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int find(int licensePlate) {
        for (int i = 0; i < size; i++) {
            if (motorbikes[i].getLicensePlate() == licensePlate) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display(int index) {
        System.out.println(motorbikes[index].toString());
    }

    @Override
    public void display() {
        for (int i = 0; i < size ; i++) {
            System.out.println(motorbikes[i].toString());
        }
    }
}
