package org.example.exercice5_jee.repository;

import org.example.exercice5_jee.model.Dog;
import org.hibernate.Session;

import java.util.List;

public class DogRepository extends Repository<Dog>{
    public DogRepository(Session session) {
        super(session);
    }

    @Override
    public Dog findById(int id) {
        return (Dog) _session.get(Dog.class,id);
    }

    @Override
    public List<Dog> findAll() {
        return _session.createQuery("from Dog ").list();
    }
}
