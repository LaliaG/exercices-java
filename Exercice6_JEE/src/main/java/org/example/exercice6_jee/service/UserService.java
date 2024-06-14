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
    public boolean create(User o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User o) {
        return false;
    }

    @Override
    public boolean delete(User o) {
        return false;
    }

    @Override
    public User findById(int id) {
        session = sessionFactory.openSession();
        User o = session.get(User.class, id);
        session.close();
        return o;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
