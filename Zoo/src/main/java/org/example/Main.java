package org.example;

import org.example.entity.ZooSimulator;
import org.example.entity.ZooSubject;
import org.example.entity.ZooVisitor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Création du zoo (Singleton)
        ZooSubject zooSimulator = ZooSimulator.getInstance();

        // Création des visiteurs
        ZooVisitor visitor1 = new ZooVisitor("Fatou");
        ZooVisitor visitor2 = new ZooVisitor("Almamy");

        // Enregistrement des visiteurs auprès du zoo
        zooSimulator.registerObserver(visitor1);
        zooSimulator.registerObserver(visitor2);

        // Simulation d'événements dans le zoo
        zooSimulator.notifyObservers("New lion added to the zoo!");
        zooSimulator.notifyObservers("Elephants are performing!");

        // Suppression d'un visiteur du zoo
        zooSimulator.removeObserver(visitor2);

        // Nouvelle notification après la suppression d'un visiteur
        zooSimulator.notifyObservers("New giraffe arrived!");
    }
}
