package org.example.exercice6_jee.service;

import org.example.exercice6_jee.model.Product;
import org.example.exercice6_jee.repository.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService extends BaseService implements Repository<Product> {
    public ProductService(){
        super();
    }

    @Override
    public boolean create(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        session = sessionFactory.openSession();
        product = (Product) session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery("from Product");
        productList = productQuery.list();
        session.close();
        return productList;
    }

    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){

        //  session.close();
        sessionFactory.close();
    }
    /*
    @Override
    public boolean create(Product o) {
        return false;
    }

    @Override
    public boolean update(Product o) {
        return false;
    }

    @Override
    public boolean delete(Product o) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }*/
}
