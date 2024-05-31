package org.example.controller;

import org.example.entities.Sale;
import org.example.service.SaleService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class SaleIhm {
    public static void main(String[] args) {
        // Configuration de la session Hibernate

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        SaleService saleService = new SaleService();

        // Création d'une nouvelle vente
        Sale newSale = new Sale(0, new Date(), 1, 1, 5);
        saleService.create(newSale);
        System.out.println("Vente créée: " + newSale.getId());

        // Mise à jour de la vente
        newSale.setQuantity(10);
        saleService.update(newSale);
        System.out.println("Vente mise à jour: " + newSale.getId());

        // Récupérer toutes les ventes
        List<Sale> sales = saleService.findAll();
        System.out.println("Liste des ventes:");
        sales.forEach(sale -> System.out.println("Vente ID: " + sale.getId()));

        // Supprimer la vente
        saleService.delete(newSale);
        System.out.println("Vente supprimée: " + newSale.getId());

        // Fermeture de la session
        saleService.close();
        sessionFactory.close();
    }
}
