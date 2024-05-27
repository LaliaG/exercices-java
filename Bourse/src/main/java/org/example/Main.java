package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Création des stocks
        Stock apple = new Stock("Apple", 150);
        Stock microsoft = new Stock("Microsoft", 250);
        Stock google = new Stock("Google", 1800);

        // Création des investisseurs
        Investor investor1 = new Investor("Youssou");
        Investor investor2 = new Investor("Babacar");

        // Abonnements des investisseurs
        investor1.subscribe(apple);
        investor1.subscribe(google);
        investor2.subscribe(microsoft);

        // Simulation du marché
        List<Stock> stocks = List.of(apple, microsoft, google);
        MarketSimulator.runSimulation(stocks, 30, 2);
        List<Investor> investors = List.of(investor1, investor2);

        // Interface utilisateur
        UserInterface ui = new UserInterface(stocks, investors);

        // Boucle pour afficher le menu et gérer les actions de l'utilisateur
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMENU");
            System.out.println("1. Afficher les actions disponibles");
            System.out.println("2. Gérer les abonnements des investisseurs");
            System.out.println("3. Afficher les notifications");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ui.displayStocks();
                    break;
                case 2:
                    ui.manageSubscriptions();
                    break;
                case 3:
                    ui.displayNotifications();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Option invalide !");
            }
        }
    }
}