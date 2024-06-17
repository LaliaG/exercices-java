package org.example.exercice6_jee.service;

import org.example.exercice6_jee.model.Product;
import org.example.exercice6_jee.repository.Repository;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService extends BaseService implements Repository<Product> {
    public ProductService(){
        super();
    }


    @Override
    public boolean create(Product product) {
        Transaction transaction = null;
        try {
            sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            closeSession();
        }
    }


    @Override
    public boolean update(Product product) {
        Transaction transaction = null;
        try {
            sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            closeSession();
        }
    }

    @Override
    public boolean delete(Product product) {
        Transaction transaction = null;
        try {
            sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            closeSession();
        }
    }

    @Override
    public Product findById(int id) {
        try {
            sessionFactory.openSession();
            return session.get(Product.class, id);
        } finally {
            closeSession();
        }
    }

    @Override
    public List<Product> findAll() {
        try {
            sessionFactory.openSession();
            Query<Product> query = session.createQuery("from Product", Product.class);
            return query.list();
        } finally {
            closeSession();
        }
    }

    @Override
    public boolean delete(int id) {
        Product product = findById(id);
        return product != null && delete(product);
    }

    private void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> product = null;
        return product;
    }

    public void createProduct(Product product) {
    }
}
