package org.example.service;

import org.example.entities.Commentaire;
import org.example.entities.Image;
import org.example.entities.Produit;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;


import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class ProduitService extends BaseService implements Repository<Produit> {

    public ProduitService(){
        super();
    }


    @Override
    public boolean create(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session = sessionFactory.openSession();
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
        // Produit produit = null;
        session = sessionFactory.openSession();
        Produit produit = session.get(Produit.class,id);
        session.close();
        return produit;
    }


    // 1. Afficher la totalité des produits
    @Override
    public List<Produit> findAll() {
        List<Produit> produitList = null;
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("from Produit ");
        produitList = produitQuery.list();
        session.close();
        return produitList;
    }

    @Override
    public List<Produit> findByPrixGreaterThan(double prix) {
        return null;
    }

    @Override
    public List<Produit> findByDateAchatBetween(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<Produit> findByStockLessThan(int stock) {
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
    public List<Produit> findByMarque(String marque) {
        return null;
    }

    public void close(){
        sessionFactory.close();
    }




    //  2. Afficher la liste des produits dont le prix est supérieur à 100 euros
    public List<Produit> filterByPrice(double min) throws Exception {
        if(min > 0) {
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where prix >= :minprice");
            produitQuery.setParameter("minprice",min);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur valeur min");
    }

    //  3. Afficher la liste des produits achetés entre deux dates.

    public List<Produit> filterByDate(Date min, Date max) throws Exception{
        if(min.before(max)){
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where dateAchat >= :datemin and dateAchat <= :datemax");
            produitQuery.setParameter("datemin",min);
            produitQuery.setParameter("datemax",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur date");
    }

    //  2. retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.
    public List<Produit> filterByStockMax(int max) throws Exception {
        if(max > 0) {
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where stock < :stockmax");
            produitQuery.setParameter("stockmax",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur valeur");
    }

    // Exercice 4
    // 1. Afficher la valeur du stock des produits d'une marque choisie.
    public double valeurStockParMarque(String marque){
        session = sessionFactory.openSession();
        Query<Double> query = session.createQuery("select sum(prix) from Produit where marque = :marque");
        query.setParameter("marque",marque);
        double valeur = query.uniqueResult();
        session.close();
        return valeur;
    }
    //       2. Calculer le prix moyen des produits.
    public double moyenne(){
        session = sessionFactory.openSession();
        Query<Double> query = session.createQuery("select avg(prix) from Produit ");
        double valeur = query.uniqueResult();
        session.close();
        return valeur;

    }
    //       3. Récupérer la liste des produits d'une marque choisie.
    public List<Produit> filterByMarque(String marque){
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("from Produit where marque = :marque");
        produitQuery.setParameter("marque",marque);
        List<Produit> produitList = produitQuery.list();
        session.close();
        return produitList;
    }
    //       4. Supprimer les produits d'une marque choisie de la table produit.
    public boolean deleteByMarque(String marque){
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("delete from Produit where marque = :marque");
        produitQuery.setParameter("marque",marque);
        session.getTransaction().begin();
        int rows = produitQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return rows > 0;
    }

    // Exercice 5
    // 2. Ajouter la possibilité d'ajouter une image à un produit.
    public boolean addNewImage(Image image, int id) {
        boolean result = false;
        Produit produit = this.findById(id);
        session =sessionFactory.openSession();
        session.getTransaction().begin();
        if(produit != null) {
            image.setProduit(produit);
            session.save(image);
            result = true;
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }


    // 3. Ajouter la possibilité d'ajouter un commentaire à un produit.
    public boolean addNewCommentaire(Commentaire commentaire, int id) {
        boolean result = false;
        Produit produit = this.findById(id);
        session =sessionFactory.openSession();
        session.getTransaction().begin();
        if(produit != null) {
            commentaire.setProduit(produit);
            session.save(commentaire);
            result = true;
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }


    // 4. Afficher les produits ave une note de 4 ou plus.
    public List<Produit> getProduitsParNoteMin(int note) {
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("select distinct produit from Commentaire where note >=:note");
        produitQuery.setParameter("note", note);
        List<Produit> produitList = produitQuery.list();
        session.close();
        return produitList;
    }

}
