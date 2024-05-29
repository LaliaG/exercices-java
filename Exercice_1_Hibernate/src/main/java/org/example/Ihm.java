package org.example;

import org.example.entities.Commande;
import org.example.entities.Produit;
import org.example.service.CommandeService;
import org.example.service.ProduitService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private ProduitService produitService;
    private CommandeService commandeService;
    private Scanner scanner;

    public Ihm(){
        scanner = new Scanner(System.in);
        produitService = new ProduitService();
        commandeService = new CommandeService();
    }

    public void start(){
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice){
                case "1" -> valeurParMarque();
                case "2" -> moyenne();
                case "3" -> produitsParMarque();
                case "4" -> deleteParMarque();
                case "5" -> ajouterImage();
                case "6" -> ajouterCommentaire();
                case "7" -> afficherProduitsAvecNote();
                case "8" -> creerCommande();
                case "9" -> afficherCommandes();
                case "10" -> afficherCommandesDuJour();
                default -> System.out.println("choix invalide");
            }

        } while (!choice.equals("0"));
        produitService.close();
        commandeService.close();
    }

    private void menu(){
        System.out.println("#######  Menu  ######");
        System.out.println("1. Afficher la valeur du stock des produits d'une marque choisie.");
        System.out.println("2. Calculer le prix moyen des produits.");
        System.out.println("3. Récupérer la liste des produits d'une marque choisie.");
        System.out.println("4. Supprimer les produits d'une marque choisie de la table produit.");
        System.out.println("5. Ajouter une image à un produit.");
        System.out.println("6. Ajouter un commentaire à un produit.");
        System.out.println("7. Afficher les produits avec une note min.");
        System.out.println("8. Créer une commande avec un ou plusieurs produits.");
        System.out.println("9. Afficher la totalité des commandes.");
        System.out.println("10. Afficher les commandes du jour.");
        System.out.println("0. Quitter.");
    }

    private void valeurParMarque(){
        System.out.println("Afficher la valeur du stock des produits d'une marque choisie.");
        System.out.println("Merci de saisir la marque :");
        String marque = scanner.nextLine();
        double valeur = produitService.valeurStockParMarque(marque);
        System.out.println("La valeur du stock pour la marque : "+marque+" est de : "+valeur);
    }

    private void moyenne(){
        System.out.println("Calculer le prix moyen des produits.");
        System.out.println("Le prix moyen des produits est de "+produitService.moyenne());
    }

    private void produitsParMarque(){
        System.out.println("Récupérer la liste des produits d'une marque choisie.");
        System.out.println("Merci de saisir la marque :");
        String marque = scanner.nextLine();
        List<Produit> produitList = produitService.filterByMarque(marque);
        for (Produit p: produitList){
            System.out.println(p);
        }
    }

    private void deleteParMarque(){
        System.out.println("Supprimer les produits d'une marque choisie de la table produit.");
        System.out.println("Merci de saisir la marque :");
        String marque = scanner.nextLine();
        if(produitService.deleteByMarque(marque)){
            System.out.println("Suppression ok");
        } else {
            System.out.println("Suppression nok");
        }
    }

    private void ajouterImage(){
        System.out.println("Ajouter une image à un produit.");
        System.out.println("Merci de saisir l'id du produit :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir l'url de l'image");
        String url = scanner.nextLine();
        // Logique pour ajouter l'image (à implémenter)
    }

    private void ajouterCommentaire(){
        System.out.println("Ajouter un commentaire à un produit.");
        System.out.println("Merci de saisir l'id du produit :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Merci de saisir le contenu du commentaire");
        String content = scanner.nextLine();
        // Logique pour ajouter le commentaire (à implémenter)
    }

    private void afficherProduitsAvecNote(){
        System.out.println("Afficher les produits avec une note min.");
        System.out.println("Merci de saisir la note min :");
        int note = scanner.nextInt();
        scanner.nextLine();
        // Logique pour afficher les produits (à implémenter)
    }

    private void creerCommande(){
        System.out.println("Créer une commande avec un ou plusieurs produits.");
        List<Produit> produits = new ArrayList<>();
        String choix;
        do {
            System.out.println("Merci de saisir l'id du produit à ajouter à la commande :");
            int id = scanner.nextInt();
            scanner.nextLine();
            Produit produit = produitService.findById(id);
            if (produit != null) {
                produits.add(produit);
            } else {
                System.out.println("Produit non trouvé.");
            }
            System.out.println("Voulez-vous ajouter un autre produit ? (y/n)");
            choix = scanner.nextLine();
        } while (choix.equalsIgnoreCase("y"));

        double total = produits.stream().mapToDouble(Produit::getPrix).sum();
        Commande commande = new Commande(produits, total, new Date());
        if (commandeService.create(commande)) {
            System.out.println("Commande créée avec succès.");
        } else {
            System.out.println("Erreur lors de la création de la commande.");
        }
    }

    private void afficherCommandes(){
        System.out.println("Afficher la totalité des commandes.");
        List<Commande> commandes = commandeService.findAll();
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }

    private void afficherCommandesDuJour(){
        System.out.println("Afficher les commandes du jour.");
        List<Commande> commandes = commandeService.findToday();
        for (Commande commande : commandes) {
            System.out.println(commande);
        }
    }
}

