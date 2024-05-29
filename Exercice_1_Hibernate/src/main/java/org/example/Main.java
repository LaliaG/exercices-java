package org.example;

import org.example.entities.Commentaire;
import org.example.entities.Image;
import org.example.entities.Produit;
import org.example.service.ProduitService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {


        ProduitService ps = new ProduitService();

        // Exercice 1
        // Créer cinq produits
        ps.create(new Produit("Apple", "i5685", 1500, 199, new SimpleDateFormat("yyyy/MM/dd").parse("2024/05/20")));
        ps.create(new Produit("Samsung", "s7985", 800, 85, new SimpleDateFormat("yyyy/MM/dd").parse("2024/01/10")));
        ps.create(new Produit("DELL", "d5685", 300, 75, new SimpleDateFormat("yyyy/MM/dd").parse("2023/07/20")));
        ps.create(new Produit("Huawei", "hu568", 20, 800, new SimpleDateFormat("yyyy/MM/dd").parse("2022/12/22")));
        ps.create(new Produit("Nokia", "3310", 50, 89, new SimpleDateFormat("yyyy/MM/dd").parse("2024/05/10")));

        // Afficher les informations du produit dont id = 2
        Produit p = ps.findById(2);
       // System.out.println(p);

        // Supprimer le produit dont id = 3
       // ps.delete(ps.findById(3));

        // Modifier les informations du produit dont id = 1
        Produit p1 = ps.findById(1);
        if (p1 != null) {
            p1.setPrix(2000);
            ps.update(p1);
        }

        // Exercice 2
        // 1. Afficher la totalité des produits
        List<Produit> produits = ps.findAll();
        for (Produit produit : produits) {
        //    System.out.println(produit);
        }

        // 2. Afficher la liste des produits dont le prix est supérieur à 100 euros
        List<Produit> produitsSuperieursA100 = ps.findByPrixGreaterThan(100);
        for (Produit produit : produitsSuperieursA100) {
            System.out.println(produit);
        }

        // 3. Afficher la liste des produits achetés entre deux dates
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse("2023/01/01");
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse("2024/01/01");
        List<Produit> produitsEntreDates = ps.findByDateAchatBetween(date1, date2);
        for (Produit produit : produitsEntreDates) {
            System.out.println(produit);
        }

        // Exercice 3
        Scanner scanner = new Scanner(System.in);

        // 1. Afficher la liste des produits commandés entre deux dates lus au clavier
        System.out.println("Entrez la première date (yyyy/MM/dd) : ");
        String dateStr1 = scanner.nextLine();
        System.out.println("Entrez la deuxième date (yyyy/MM/dd) : ");
        String dateStr2 = scanner.nextLine();
        Date dateClavier1 = new SimpleDateFormat("yyyy/MM/dd").parse(dateStr1);
        Date dateClavier2 = new SimpleDateFormat("yyyy/MM/dd").parse(dateStr2);
        List<Produit> produitsEntreDatesClavier = ps.findByDateAchatBetween(dateClavier1, dateClavier2);
        for (Produit produit : produitsEntreDatesClavier) {
            System.out.println(produit);
        }

        // 2. Retourner les numéros et références des articles dont le stock est inférieur à une valeur lue au clavier
        System.out.println("Entrez la valeur de stock maximum : ");
        int stockMax = scanner.nextInt();
        List<Produit> produitsStockInferieur = ps.findByStockLessThan(stockMax);
        for (Produit produit : produitsStockInferieur) {
            System.out.println("Numéro: " + produit.getId() + ", Référence: " + produit.getReference());
        }

        // Afficher la valeur du stock des produits d'une marque choisie
        int valeurStockApple = ps.calculateStockValueByMarque("Apple");
        System.out.println("Valeur du stock des produits Apple: " + valeurStockApple);

        // Calculer le prix moyen des produits
        double prixMoyen = ps.calculateAveragePrix();
        System.out.println("Prix moyen des produits: " + prixMoyen);

        // Récupérer la liste des produits d'une marque choisie
        List<Produit> produitsApple = ps.findByMarque("Apple");
        produitsApple.forEach(System.out::println);

        // Supprimer les produits d'une marque choisie de la table produit
        boolean deleted = ps.deleteByMarque("Nokia");
        System.out.println("Produits Nokia supprimés: " + deleted);

        // Ajouter une image à un produit
        Produit produitApple = ps.findById(1);
        if (produitApple != null) {
            Image image1 = new Image("http://example.com/image1.jpg", produitApple);
            ps.addNewImage(image1, produitApple.getId());
        }

        // Ajouter un commentaire à un produit
        if (produitApple != null) {
            Commentaire commentaire1 = new Commentaire("Super produit!", new Date(), 5, produitApple);
            ps.addNewCommentaire(commentaire1, produitApple.getId());
        }

        // Afficher la liste des produits avec une note de 4 ou plus
        List<Produit> produitsWithGoodNotes = ps.getProduitsParNoteMin(4);
        produitsWithGoodNotes.forEach(System.out::println);



        ps.close();
        scanner.close();
    }
}


