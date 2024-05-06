package org.example;

public class SharedVehicleState extends VehicleFlyWeight {
    private String model;
    private String brand;
    private String color;

    public SharedVehicleState(String model, String brand, String color) {
        this.model = model;
        this.brand = brand;
        this.color = color;
    }

    @Override
    public void rent(String customer) {
        System.out.println("Vehicle " + model + " rented to " + customer);
    }


}
