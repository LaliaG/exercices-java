package org.example.exercice6_jee.service;

import org.example.exercice6_jee.model.User;
import org.example.exercice6_jee.repository.Repository;
import org.example.exercice6_jee.repository.UserRepository;


import java.util.List;
//o == entity == user == u

public class UserService extends BaseService implements Repository<User> {
    private UserRepository userRepository;
    public UserService(){
        super();
    }
   /* public UserService(){

       userRepository = new UserRepository();
    }*/

    @Override
    public boolean create(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean delete(User user) {
        return user != null && userRepository.delete(user);
    }


    @Override
    public boolean delete(int id) {
        User user = findById(id);
        return user != null && userRepository.delete(user);
    }

    @Override
    public User findById(int id) {
        session = sessionFactory.openSession();
        User o = session.get(User.class, id);
        session.close();
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
