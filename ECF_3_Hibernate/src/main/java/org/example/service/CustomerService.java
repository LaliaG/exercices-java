package org.example.service;

import org.example.entities.Customer;
import org.example.entities.Sale;
import org.example.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerService extends BaseService implements Repository<Customer> {
    public CustomerService() {
        super();
    }


    @Override
    public boolean create(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Customer findById(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.list();
        session.close();
        return customers;
    }

    // Méthode pour récupérer l'historique des achats d'un client
    public List<Sale> getPurchaseHistory(int customerId) {
        Customer customer = findById(customerId);
        if (customer != null) {
            return customer.getPurchaseHistory();
        }
        return null;
    }

    // Méthode pour rechercher les clients par nom
    public List<Customer> findByName(String name) {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer where name = :name", Customer.class);
        query.setParameter("name", name);
        List<Customer> customerList = query.list();
        session.close();
        return customerList;
    }

    // Méthode pour rechercher les clients par adresse e-mail
    public Customer findByEmail(String email) {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer where email = :email", Customer.class);
        query.setParameter("email", email);
        Customer customer = query.uniqueResult();
        session.close();
        return customer;
    }

    public void close() {
    }

    public void create(String bob, String mail) {
    }
}
