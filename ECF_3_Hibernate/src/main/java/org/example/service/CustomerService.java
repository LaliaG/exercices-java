package org.example.service;

import org.example.entities.Customer;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerService extends BaseService<Customer> implements Repository<Customer> {
    public CustomerService() {
        super();
    }

    @Override
    public boolean create(Customer customer) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Customer customer) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Customer findById(int id) {
        session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        session.close();
        return customerList;
    }

    // Méthode pour rechercher les clients par nom
    public List<Customer> findByName(String name) {
        session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer where name = :name");
        query.setParameter("name", name);
        List<Customer> customerList = query.list();
        session.close();
        return customerList;
    }

    // Méthode pour rechercher les clients par adresse e-mail
    public Customer findByEmail(String email) {
        session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer where email = :email");
        query.setParameter("email", email);
        Customer customer = query.uniqueResult();
        session.close();
        return customer;
    }

}
