package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();

        Vehicle vehicle1 = FlyWeightFactory.getVehicle("Model1", "Brand1", "Red");
        Vehicle vehicle2 = FlyWeightFactory.getVehicle("Model1", "Brand1", "Red");

        System.out.println(vehicle1 == vehicle2); //

        vehicle1.rent("Customer1");
        vehicle2.rent("Customer2");

    }
}