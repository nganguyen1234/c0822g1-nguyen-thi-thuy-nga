package oop_exercise.service;

import oop_exercise.model.Truck;

public interface ITruckService {
    void add(Truck truck);
    boolean remove(int licensePlate);
    int find(int licensePlate);
    void display(int index);
    void display();
}
