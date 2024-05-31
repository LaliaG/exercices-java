package org.example.controller;

import org.example.entities.Customer;
import org.example.service.CustomerService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class
CustomerIhm {
    public static void main(String[] args) {
        // Configuration de la session Hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        CustomerService customerService = new CustomerService();

        // Création d'un nouveau client
        Customer newCustomer = new Customer(0, "John Doe", "john.doe@example.com", null);
        customerService.create(newCustomer);
        System.out.println("Client créé: " + newCustomer.getName());

        // Mise à jour du client
        newCustomer.setName("John A. Doe");
        customerService.update(newCustomer);
        System.out.println("Client mis à jour: " + newCustomer.getName());

        // Récupérer tous les clients
        List<Customer> customers = customerService.findAll();
        System.out.println("Liste des clients:");
        customers.forEach(customer -> System.out.println("Customer: " + customer.getName()));

        // Supprimer le client
        customerService.delete(newCustomer);
        System.out.println("Client supprimé: " + newCustomer.getName());

        // Fermeture de la session
        customerService.close();
        sessionFactory.close();
    }
}
