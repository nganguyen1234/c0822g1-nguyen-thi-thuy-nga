package oop_exercise.service;

import sun.plugin2.message.transport.Transport;

public interface TransportSerive {
    void add();
    boolean remove(int licensePlate);
    int find(int licensePlate);
    void display();
    void display(int index);
}
