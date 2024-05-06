package org.example.factory;

import org.example.CarType;
import org.example.entity.AllTerrainCar;
import org.example.entity.Car;
import org.example.entity.ElectricCar;
import org.example.entity.ThermicCar;

public class TypeCarFactory extends CarFactory {

        @Override
        public Car createCar(CarType type) {
            switch (type) {
                case ELECTRIC:
                    return
                            new ElectricCar(1, 100);
                case THERMIC:
                    return new ThermicCar(2, 75);
                case ALL_TERRAIN:
                    return new AllTerrainCar(3, 50);
                default:
                    throw new IllegalArgumentException("Type de voiture non valide: " + type);
            }
        }
    }

