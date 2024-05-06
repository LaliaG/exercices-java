package org.example.factory;

import org.example.entity.Animal;
import org.example.entity.Elephant;

public class ElephantFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Elephant();
    }
}
