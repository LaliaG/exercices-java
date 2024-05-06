package org.example;

public class Client {
    public static void main(String[] args) {

        Book realBook = new RealBook("Real Book Title", "Real Book Content");

        System.out.println("Attempting to read real book directly:");
        realBook.readBook(content);

        // Création d'un proxy sécurisé avec un utilisateur premium
        Book securedBookProxyPremium = new SecuredBookProxy("Secured Book Title", "Secured Book Content", true);

        System.out.println("\nAttempting to read secured book with premium access:");
        securedBookProxyPremium.readBook(title, content);

        Book securedBookProxyNonPremium = new SecuredBookProxy("Secured Book Title", "Secured Book Content", false);

        // Accès au livre sécurisé sans utilisateur premium
        System.out.println("\nAttempting to read secured book without premium access:");
        securedBookProxyNonPremium.readBook(title, content);
    }
}
