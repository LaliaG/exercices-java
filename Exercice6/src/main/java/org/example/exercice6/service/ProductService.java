package org.example.exercice6.service;

import org.example.exercice6.repository.ProductRepository;
import org.hibernate.query.Query;

public class ProductService extends BaseService implements ProductRepository<Produit>  {
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
        Produit produit = null;
        session = sessionFactory.openSession();
        produit = (Produit) session.get(Produit.class, id);
        session.close();
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produitList = null;
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("from Produit");
        produitList = produitQuery.list();
        session.close();
        return produitList;
    }

    public List<Produit> filterByPrice(double min) throws Exception{
        if (min >= 0){
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where prix >= :min");
            produitQuery.setParameter("min",min);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw new Exception("erreur valeur");
    }

    public List<Produit> filterByDate(Date min, Date max) throws Exception{
        if(min.before(max)){
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where dateAchat >= :min and dateAchat <= :max ");
            produitQuery.setParameter("min",min);
            produitQuery.setParameter("max",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw new Exception("erreur date");
    }

    public List<Produit> filterByStockMax(int max) throws Exception{
        if (max >= 0){
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where stock < :max");
            produitQuery.setParameter("max",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw new Exception("erreur valeur");
    }

    public double valeurStockParMarque(String marque) {
        session = sessionFactory.openSession();
        Query<Double> query = session.createQuery("select sum(prix) from Produit where marque =:marque");
        query.setParameter("marque", marque);
        double valeur = query.uniqueResult();
        session.close();
        return valeur;
    }

    public double moyenne() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Double> query = session.createQuery("select avg(prix) from Produit");
        double moy = query.uniqueResult();
        session.close();
        return moy;
    }

    public List<Produit> filterByMarques(List<String> marques) throws Exception {
        if(marques.size() > 0) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Query<Produit> produitQuery = session.createQuery("from Produit where marque in :marques");
            produitQuery.setParameter("marques", marques);
            List<Produit> produitList = produitQuery.list();
            session.getTransaction().commit();
            session.close();
            return produitList;
        }
        throw new Exception("aucune marque");
    }

    public boolean deleteByMarque(String marque) {

        session = sessionFactory.openSession();

        Query query = session.createQuery("delete Produit where marque = :marque");
        query.setParameter("marque", marque);
        session.getTransaction().begin();
        int success = query.executeUpdate(); // C'est le nombre de ligne affectée par la requete
        session.getTransaction().commit();
        session.close();
        return success > 0;
    }



    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){

        //  session.close();
        sessionFactory.close();
    }

}
