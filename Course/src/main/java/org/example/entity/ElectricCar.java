package org.example.entity;

public class ElectricCar extends Car {

    public ElectricCar(int id, int initialPosition) {
        super(id, initialPosition);
        this.setSpeed(2);
    }
}
