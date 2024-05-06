package org.example.factory;

import org.example.entity.AbstractProductBuilder;
import org.example.entity.Product;

import java.util.Scanner;

public class IUIFactory {
    private static Scanner scanner = new Scanner(System.in);
    public static <ProductBuilder> void main(String[] args) {
        System.out.println("Bienvenue dans l'interface de configuration de produits ");
        while (true) {
            System.out.println("Choisissez le type de produit à configurer:");
            System.out.println("1. Ordinateur");
            System.out.println("2. Vélo");
            System.out.println("3. Smartphone");
            System.out.println("4. Quitter");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                System.out.println("Au revoir !");
                break;
            }

            ProductFactory factory = null;
            switch (choice) {
                case 1:
                    factory = new ProductFactory() {
                        @Override
                        public Product createProduct(AbstractProductBuilder computerBuilder) {
                            return computerBuilder.build();
                        }
                    };
                    break;
                case 2:
                    factory = new ProductFactory() {
                        @Override
                        public Product createProduct(AbstractProductBuilder bikeBuilder) {
                            return bikeBuilder.build();
                        }
                    };
                    break;
                case 3:
                    factory = new ProductFactory() {
                        @Override
                        public Product createProduct(AbstractProductBuilder smartphoneBuilder) {
                            return smartphoneBuilder.build();
                        }
                    };
                    break;
                default:
                    System.out.println("Choix invalide !");
                    continue;
            }

            ProductBuilder builder = factory.createBuilder();
            builder.choiceComponents();
            builder.choiceColors();

            Product product = builder.build();

            System.out.println("Votre produit configuré:");
            product.show();

            System.out.println("---------------------------------------------------");
        }
        scanner.close();
    }

}








