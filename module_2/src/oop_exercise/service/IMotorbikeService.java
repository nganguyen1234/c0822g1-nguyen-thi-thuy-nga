package oop_exercise.service;

import oop_exercise.model.Motorbike;

public interface IMotorbikeService {
    void add(Motorbike motorBike);
    boolean remove(int licensePlate);
    int find(int licensePlate);
    void display(int index);
    void display();
}
