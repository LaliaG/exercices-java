package org.example.entity;

public class Car {
    private int id;
    private int position;
    private int speed;

    public Car(int id, int initialPosition) {
        this.id = id;
        this.position = 0;
        this.speed = 1; // Vitesse initiale de la voiture
    }

    // Méthode pour déplacer la voiture
    public void move() {
        // Calculer la nouvelle position en ajoutant la vitesse actuelle de la voiture
        position += speed;
    }

    // Méthodes getters et setters
    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

