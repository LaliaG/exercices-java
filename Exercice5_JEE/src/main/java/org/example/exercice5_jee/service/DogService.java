package org.example.exercice5_jee.service;

import org.example.exercice5_jee.model.Dog;
import org.example.exercice5_jee.repository.DogRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DogService {
    private final DogRepository dogRepository;

    public DogService(Session session) {
        this.dogRepository = new DogRepository(session);
    }

    public void addDog(Dog dog) {
        Transaction transaction = null;
        try {
            transaction = dogRepository.getSession().beginTransaction();
            dogRepository.create(dog);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Dog getDogById(int id) {
        return dogRepository.findById(id);
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }


}
