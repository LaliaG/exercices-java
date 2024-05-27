package org.example;

import org.example.entity.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Création du contrôleur de course
        RaceController raceController = RaceController.getInstance();

        // Création des voitures avec des identifiants uniques
        Car electricCar1 = new ElectricCar(1, 100);
        Car thermicCar1 = new ThermicCar(2,75);
        Car allTerrainCar1 = new AllTerrainCar(3, 50);

        // Ajout des voitures au contrôleur de course
        raceController.addCar(electricCar1);
        raceController.addCar(thermicCar1);
        raceController.addCar(allTerrainCar1);

        // Création de l'observateur de position
        PositionObserver racePositionObserver = new RacePositionObserver();

        // Ajout de l'observateur au contrôleur de course
        raceController.addObserver(racePositionObserver);

        // Démarrage de la course
        raceController.startRace();
    }
}