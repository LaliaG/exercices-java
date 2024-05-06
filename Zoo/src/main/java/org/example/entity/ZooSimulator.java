package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class ZooSimulator implements ZooSubject {
    private static ZooSimulator instance;
    private List<ZooVisitor> observers;

    private ZooSimulator() {
        observers = new ArrayList<>();
    }

    public static synchronized ZooSimulator getInstance() {
        if (instance == null) {
            instance = new ZooSimulator();
        }
        return instance;
    }

    @Override
    public void registerObserver(ZooVisitor observer) {
        observers.add(observer);
    }


    @Override
    public void removeObserver(ZooVisitor observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (ZooVisitor observer : observers) {
            observer.update(event);
        }
    }

}

