package org.example;

import org.example.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private static RaceController instance;
    private static final int FINISH_LINE_POSITION = 1000;

    private
    List<Car> cars;
    private List<PositionObserver> observers;

    private RaceController() {
        cars = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized RaceController getInstance() {
        if (instance == null) {
            instance = new RaceController();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void addObserver(PositionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PositionObserver observer) {
        observers.remove(observer);
    }

    public void startRace() {
        // Initialisation des variables pour suivre le nombre de tours et le vainqueur
        int numberOfLaps = 0;
        Car winner = null;
        // Boucle tant qu'il n'y a pas de vainqueur
        while (winner == null) {
            // Incrémentation du nombre de tours à chaque itération
            numberOfLaps++;
            System.out.println("Début du tour numéro" + numberOfLaps);

            // Déplacer chaque voiture et vérifier si l'une d'elles a franchi la ligne d'arrivée
            boolean allCarsFinished = true;
            for (Car car : cars) {
                car.move();
                int position = car.getPosition();
                // Mettre à jour les observateurs avec la nouvelle position
                for (PositionObserver observer : observers) {
                    observer.updatePosition(car.getId(), position);
                }
                // Vérifier si la voiture a franchi la ligne d'arrivée
                if (position >= FINISH_LINE_POSITION) {
                    winner = car;
                    break;

                }
            }
            // Sort de la boucle si un vainqueur est déterminé avant d'annoncer le vainqueur
            if (winner != null || numberOfLaps > 10) {
                break;
            }

        }
        // Vérifie si un vainqueur a été déterminé avant d'annoncer le vainqueur
        if (winner != null) {
            System.out.println("Le vainqueur est la voiture " + winner.getId());
        } else {
            System.out.println("Aucune voiture n'a franchi la ligne d'arrivée.");


        }
    }
}