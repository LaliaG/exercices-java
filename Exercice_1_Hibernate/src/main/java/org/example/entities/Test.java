package org.example.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // Création d'un registre pour charger la configuration à partir de notre fichier de configuration
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        // Création de la session
        Session session = sessionFactory.openSession();
        // Dés l'ouverture de la session, et en fonction de la propriété hibernate.hbm2ddl.auto hibernate va agir sur la base de donnée

/*
        // Ajout d'un produit
        session.getTransaction().begin();
        Product pr = new Product();
        pe.setNom("toto");
        pe.setPrenom("tata");
        session.save(pe);
        System.out.println("ID de la personne : " + pe.getId());

        session.getTransaction().commit();

 */

      //  private static void save(Session session) {
            session.beginTransaction();

            Product p1 = Product.builder().brand("Marque1").reference("Ref1").datePurchase(new Date()).price(100.0).stock(10).build();
            Product p2 = Product.builder().brand("Marque2").reference("Ref2").datePurchase(new Date()).price(200.0).stock(20).build();
            Product p3 = Product.builder().brand("Marque3").reference("Ref3").datePurchase(new Date()).price(300.0).stock(30).build();
            Product p4 = Product.builder().brand("Marque4").reference("Ref4").datePurchase(new Date()).price(400.0).stock(40).build();
            Product p5 = Product.builder().brand("Marque5").reference("Ref5").datePurchase(new Date()).price(500.0).stock(50).build();

            session.save(p1);
            session.save(p2);
            session.save(p3);
            session.save(p4);
            session.save(p5);

            session.getTransaction().commit();
       // }

       // private static void ShowProductById(Session session, 2) {
            session.beginTransaction();

            Product product = session.get(Product.class, 2);
            if (product != null) {
                System.out.println("Produit trouvé : " + product);
            } else {
                System.out.println("Produit avec ID " + 2 + " non trouvé.");
            }

            session.getTransaction().commit();
       // }

       // private static void deleteProductById(Session session, 3) {
            session.beginTransaction();

            Product product = session.get(Product.class, 3);
            if (product != null) {
                session.delete(product);
                System.out.println("Produit avec ID " + 3 + " supprimé.");
            } else {
                System.out.println("Produit avec ID " + 3 + " non trouvé.");
            }

            session.getTransaction().commit();
        //}

      //  private static void updateProductById(Session session, 1) {
            session.beginTransaction();

            Product product = session.get(Product.class, 1);
            if (product != null) {
                product.setBrand("Marque1 modifié");
                product.setReference("Ref1 modifié");
                product.setPrice(150.0);
                product.setStock(15);
                session.update(product);
                System.out.println("Produit avec ID " + 1 + " mis à jour.");
            } else {
                System.out.println("Produit avec ID " + 1 + " non trouvé.");
            }

            session.getTransaction().commit();


        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    //}


}

}
