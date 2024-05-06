package org.example.factory;

import org.example.entity.Animal;
import org.example.entity.Lion;

public class LionFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Lion();
    }
}
