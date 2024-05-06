package org.example.factory;

import org.example.entity.Animal;
import org.example.entity.Giraffe;

public class GiraffeFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Giraffe();
    }

}
