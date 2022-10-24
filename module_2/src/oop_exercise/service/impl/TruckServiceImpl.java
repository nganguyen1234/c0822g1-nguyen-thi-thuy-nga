package oop_exercise.service.impl;

import oop_exercise.model.Truck;
import oop_exercise.service.ITruckService;

import java.util.Arrays;

public class TruckServiceImpl implements ITruckService {

    private Truck[] trucks = new Truck[100];
    private int size = 0;

    @Override
    public void add(Truck truck) {
        if (size >= trucks.length) {
            trucks = Arrays.copyOf(trucks, size + trucks.length / 2);
            trucks[size] = truck;
            size++;
        } else {
            trucks[size] = truck;
            size++;
        }
    }

    @Override
    public boolean remove(int licensePlate) {
        int index = this.find(licensePlate);
        if (index != -1) {
            System.arraycopy(trucks, index + 1, trucks, index, size - 1 - index);
            trucks[size-1] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int find(int licensePlate) {
        for (int i = 0; i < size; i++) {
            if (trucks[i].getLicensePlate() == licensePlate) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display(int index) {
        System.out.println(trucks[index].toString());
    }

    @Override
    public void display() {
        for (int i = 0; i < size ; i++) {
            System.out.println(trucks[i].toString());
        }
    }

}
