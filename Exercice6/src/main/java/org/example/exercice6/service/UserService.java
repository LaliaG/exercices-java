package org.example.exercice6.service;

import org.example.exercice6.model.User;
import org.example.exercice6.repository.Repository;
import org.example.exercice6.repository.UserRepository;

import java.util.List;

public class UserService{
    public User findByEmailAndPassword(String email, String password) {
        return UserRepository.findByEmailAndPassword(email, password);
    }
    /*
    public UserService(){
        super();
    }

    @Override
    public boolean create(User u) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User u) {
        return false;
    }

    @Override
    public boolean delete(User u) {
        return false;
    }

    @Override
    public User findById(int id) {
        session = sessionFactory.openSession();
        User u = session.get(User.class, id);
        session.close();
        return u;
    }

    @Override
    public List<User> findAll() {
        return null;
    }*/
}
