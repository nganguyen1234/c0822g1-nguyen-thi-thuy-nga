package oop_exercise.service.impl;

import oop_exercise.model.Car;
import oop_exercise.service.ICarService;

import java.util.Arrays;
import java.util.Scanner;

public class CarServiceImpl implements ICarService {
    private Car[] cars = new Car[100];
    private Scanner scanner = new Scanner(System.in);
    private int size = 0;

    @Override
    public void add(Car car) {
        if (size >= cars.length) {
            cars = Arrays.copyOf(cars, size + cars.length / 2);
            cars[size] = car;
            size++;
        } else {
            cars[size] = car;
            size++;
        }
    }

    @Override
    public boolean remove(int licensePlate) {
        int index = this.find(licensePlate);
        if (index != -1) {
            System.arraycopy(cars, index + 1, cars, index, size - 1 - index);
            cars[size-1] = null;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int find(int licensePlate) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getLicensePlate() == licensePlate) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display(int index) {
        System.out.println(cars[index].toString());
    }

    @Override
    public void display() {
        for (int i = 0; i < size ; i++) {
            System.out.println(cars[i].toString());
        }
    }
}
