package org.example;

public class RacePositionObserver implements PositionObserver {

    @Override
    public void updatePosition(int carId, int newPosition) {
        System.out.println("Car " + carId + " moved to position " + newPosition);
    }
}
