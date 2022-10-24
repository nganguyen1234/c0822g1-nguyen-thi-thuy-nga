package oop_exercise.service;

import oop_exercise.model.Car;

public interface ICarService {
    void add(Car car);
    boolean remove(int licensePlate);
    int find(int licensePlate);
    void display(int index);
    void display();
}
