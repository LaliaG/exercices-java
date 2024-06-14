package org.example.exercice6.repository;

import org.example.exercice6.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserRepository extends Repository<User> {
    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public static User findByEmailAndPassword(String email, String password) {
        return null;
    }

    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public User findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    @Override
    public User findById(int id) {
        return (User) _session.get(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return  _session.createQuery("from User ").list();
    }
}
