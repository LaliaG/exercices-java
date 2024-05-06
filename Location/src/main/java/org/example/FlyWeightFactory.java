package org.example;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {
    private static Map<String, SharedVehicleState> flyweights = new HashMap<>();

    public static Vehicle getVehicle(String model1, String brand1, String red) {
        String model = new String();
        String brand = new String();
        String color = new String();
        SharedVehicleState flyweight = getFlyweight(model, brand, color);
        return new Vehicle(2022, 20000, flyweight);
    }
    public static SharedVehicleState getFlyweight(String model, String brand, String color) {
        String key = model + brand + color;

        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new SharedVehicleState(model, brand, color));
        }

        return flyweights.get(key);
    }
}
