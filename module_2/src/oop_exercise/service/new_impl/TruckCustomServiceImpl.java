package oop_exercise.service.impl;

import oop_exercise.model.Truck;
import oop_exercise.service.ITruckService;

public class TruckCustomServiceImpl implements ITruckService {

    private final Truck[] trucks = new Truck[100];

    @Override
    public void add(Truck truck) {
        if (this.trucks.length == 0) this.trucks[0] = truck;
        else this.trucks[this.trucks.length - 1] = truck;
    }
}
