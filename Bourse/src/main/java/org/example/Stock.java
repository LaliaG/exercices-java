package org.example;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Getter

public class Stock implements Subject<Stock> {
    private String name;
    private double price;
    List<Observer<Stock>> observers;
    private Random random;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
        this.observers = new ArrayList<>();
        random = new Random();
    }
    public void updatePrice() {
            double variation = new Random().nextDouble() * 10 - 5; // Variation de prix entre -5 et 5
            price += variation;
            notifyObserver(this);
    }


    @Override
    public void registerObserver(Observer<Stock> observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer<Stock> observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObserver(Stock element) {
        observers.forEach(o->o.update(this));

    }

}
