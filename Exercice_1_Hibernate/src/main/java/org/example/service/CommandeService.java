package org.example.service;

import org.example.entities.Commande;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class CommandeService extends BaseService implements Repository<Commande> {
    public CommandeService() {
        super();
    }
    public boolean create(Commande commande) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(commande);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Commande o) {
        return false;
    }

    @Override
    public boolean delete(Commande o) {
        return false;
    }

    @Override
    public Commande findById(int id) {
        return null;
    }

    public List<Commande> findAll() {
        session = sessionFactory.openSession();
        Query<Commande> query = session.createQuery("from Commande", Commande.class);
        List<Commande> commandes = query.list();
        session.close();
        return commandes;
    }

    @Override
    public List<Commande> findByPrixGreaterThan(double prix) {
        return null;
    }

    @Override
    public List<Commande> findByDateAchatBetween(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<Commande> findByStockLessThan(int stock) {
        return null;
    }

    @Override
    public int calculateStockValueByMarque(String marque) {
        return 0;
    }

    @Override
    public double calculateAveragePrix() {
        return 0;
    }

    @Override
    public List<Commande> findByMarque(String marque) {
        return null;
    }

    @Override
    public boolean deleteByMarque(String marque) {
        return false;
    }

    public List<Commande> findToday() {
        session = sessionFactory.openSession();
        Query<Commande> query = session.createQuery("from Commande where dateCommande = :today", Commande.class);
        query.setParameter("today", new Date());
        List<Commande> commandes = query.list();
        session.close();
        return commandes;
    }

    public void close() {
        sessionFactory.close();
    }
}
