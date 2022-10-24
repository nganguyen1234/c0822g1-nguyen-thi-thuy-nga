package oop_exercise.service;

import oop_exercise.model.MotorBike;
import oop_exercise.model.Truck;

public interface IMotorbikeService {
    void add(MotorBike motorBike);
    boolean remove(int licensePlate);
    int find(int licensePlate);
    void display(int index);
    void display();
}
