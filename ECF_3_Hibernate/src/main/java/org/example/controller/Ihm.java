package org.example.controller;

import org.example.service.CustomerService;
import org.example.service.ItemService;
import org.example.service.SaleService;

import java.util.Scanner;

public class Ihm {
    private CustomerService customerService;
    private ItemService itemService;
    private SaleService saleService;
    private Scanner scanner;
    private SaleService sessionFactory;

    public Ihm(){
        scanner = new Scanner(System.in);
        customerService = new CustomerService();
        itemService = new ItemService();
        saleService = new SaleService();
    }
    
    public void start() {
        while (true) {
            System.out.println("1. Gestion des clients");
            System.out.println("2. Gestion des articles");
            System.out.println("3. Gestion des ventes");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CustomerIhm customerIhm = new CustomerIhm();
                    customerIhm.main(null);
                    break;
                case 2:
                    ItemIhm itemIhm = new ItemIhm();
                    itemIhm.main(null);
                    break;
                case 3:
                    SaleIhm saleIhm = new SaleIhm();
                    saleIhm.main(null);
                    break;
                case 4:
                    sessionFactory.close();
                    System.out.println("Au revoir!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }


    }
}
