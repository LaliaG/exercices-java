package org.example.exercice6_jee.service;

import org.example.exercice6_jee.model.User;
import org.example.exercice6_jee.repository.Repository;

import java.util.List;
//o == entity == user == u

public class UserService extends BaseService implements Repository<User> {
    public UserService(){
        super();
    }

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
}
