package org.example.exercice5_jee.service;

import org.example.exercice5_jee.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> findAll();
    void save(Dog dog);
}
