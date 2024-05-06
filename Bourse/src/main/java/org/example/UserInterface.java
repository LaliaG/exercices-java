package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Stock> stocks;
    private List<Investor> investors;
    private Scanner scanner;

    public UserInterface(List<Stock> stocks, List<Investor> investors) {
        this.stocks = stocks;
        this.investors = investors;
        this.scanner = new Scanner(System.in);
    }

    public void displayStocks() {
        System.out.println("Liste des actions disponibles :");
        for (Stock stock : stocks) {
            System.out.println(stock.getName() + " - Prix actuel : " + stock.getPrice());
        }
    }

    public void manageSubscriptions() {
        System.out.println("Gestion des abonnements :");
        for (int i = 0; i < investors.size(); i++) {
            System.out.println((i + 1) + ". " + investors.get(i).getName());
        }
        System.out.print("Choisissez un investisseur : ");
        int investorIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Investor investor = investors.get(investorIndex);

        System.out.println("Actions disponibles :");
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println((i + 1) + ". " + stocks.get(i).getName());
        }
        System.out.print("Choisissez une action à laquelle s'abonner : ");
        int stockIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Stock stock = stocks.get(stockIndex);

        investor.subscribe(stock);
        System.out.println(investor.getName() + " s'est abonné à " + stock.getName());
    }

    public void displayNotifications() {
        System.out.println("Affichage des notifications en temps réel :");
        boolean exit = false;
        while (!exit) {
            for (Investor investor : investors) {
                System.out.println("Notifications pour l'investisseur " + investor.getName() + " :");
                // Vérifier s'il y a des notifications pour cet investisseur
                List<String> notifications = investor.getNotifications();
                if (!notifications.isEmpty()) {
                    for (String notification : notifications) {
                        System.out.println(notification);
                    }
                    investor.clearNotifications();
                } else {
                    System.out.println("Pas de nouvelles notifications.");
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interruption de l'attente des notifications.");
                exit = true;
            }
        }
    }

}

