package org.example.exercice6.repository;

import org.example.exercice6.model.Product;
import org.example.exercice6.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductRepository extends Repository<Product> {
    private final SessionFactory sessionFactory;

    public ProductRepository(SessionFactory sessionFactory) {
        super(SessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    Product findById(int id) {
        return null;
    }

    public void save(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Product", Product.class).list();
        }
    }
}
