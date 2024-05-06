package org.example.factory;

import org.example.CarType;
import org.example.entity.Car;

public abstract class CarFactory {
    public abstract
    Car createCar(CarType type);


}

