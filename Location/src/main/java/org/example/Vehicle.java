package org.example;

public class Vehicle {
    private int year;
    private double price;
    private VehicleFlyWeight flyWeight;

    public Vehicle(int year, double price, VehicleFlyWeight flyWeight) {
        this.year = year;
        this.price = price;
        this.flyWeight = flyWeight;
    }


    public void rent(String customer) {
        this.flyWeight.rent(customer);

    }

}
