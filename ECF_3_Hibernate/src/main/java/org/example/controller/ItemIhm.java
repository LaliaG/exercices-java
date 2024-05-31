package org.example.controller;

import org.example.entities.Item;
import org.example.service.ItemService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ItemIhm {
    public static void main(String[] args) {
        // Configuration de la session Hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        ItemService itemService = new ItemService();

        // Création d'un nouvel article
        Item newItem = new Item(0, "Item 1", 100.0, 10);
        itemService.create(newItem);
        System.out.println("Article créé: " + newItem.getDescription());

        // Mise à jour de l'article
        newItem.setDescription("Updated Item 1");
        itemService.update(newItem);
        System.out.println("Article mis à jour: " + newItem.getDescription());

        // Récupérer tous les articles
        List<Item> items = itemService.findAll();
        System.out.println("Liste des articles:");
        items.forEach(item -> System.out.println("Article: " + item.getDescription()));

        // Supprimer l'article
        itemService.delete(newItem);
        System.out.println("Article supprimé: " + newItem.getDescription());

        // Fermeture de la session
        itemService.close();
        sessionFactory.close();
    }

}
