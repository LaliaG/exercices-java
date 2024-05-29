package org.example.service;

import org.example.entities.Produit;
import org.example.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProduitService extends BaseService implements Repository<Produit> {

    public ProduitService() {
        super();
    }

    @Override
    public boolean create(Produit o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Produit findById(int id) {
        session = sessionFactory.openSession();
        Produit produit = session.get(Produit.class, id);
        session.close();
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        session = sessionFactory.openSession();
        List<Produit> produits = session.createQuery("from Produit", Produit.class).list();
        session.close();
        return produits;
    }

    @Override
    public List<Produit> findByPrixGreaterThan(double prix) {
        session = sessionFactory.openSession();
        Query<Produit> query = session.createQuery("from Produit where prix > :prix", Produit.class);
        query.setParameter("prix", prix);
        List<Produit> produits = query.list();
        session.close();
        return produits;
    }

    @Override
    public List<Produit> findByDateAchatBetween(Date startDate, Date endDate) {
        session = sessionFactory.openSession();
        Query<Produit> query = session.createQuery("from Produit where dateAchat between :startDate and :endDate", Produit.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<Produit> produits = query.list();
        session.close();
        return produits;
    }

    @Override
    public List<Produit> findByStockLessThan(int stock) {
        session = sessionFactory.openSession();
        Query<Produit> query = session.createQuery("from Produit where stock < :stock", Produit.class);
        query.setParameter("stock", stock);
        List<Produit> produits = query.list();
        session.close();
        return produits;
    }

    public void close() {
        sessionFactory.close();
    }
}

