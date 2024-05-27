package org.example;

import org.example.IHM.ProductElectronicIHM;
import org.example.IHM.ProductFoodIHM;
import org.example.IHM.ProductHousingIHM;
import org.example.Repository.ProductElectronicRepository;
import org.example.Repository.ProductFoodRepository;
import org.example.Repository.ProductHousingRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Product_JPA");
        EntityManager em = emf.createEntityManager();

        ProductFoodRepository foodRepository = new ProductFoodRepository(em);
        ProductElectronicRepository electronicRepository = new ProductElectronicRepository(em);
        ProductHousingRepository housingRepository = new ProductHousingRepository(em);

        ProductFoodIHM foodIHM = new ProductFoodIHM(foodRepository);
        ProductElectronicIHM electronicIHM = new ProductElectronicIHM(electronicRepository);
        ProductHousingIHM housingIHM = new ProductHousingIHM(housingRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select product type:");
            System.out.println("1. Food");
            System.out.println("2. Electronic");
            System.out.println("3. Housing");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 4) {
                break;
            }

            System.out.println("Select operation:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. List all");

            int operation = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    performOperation(foodIHM, electronicIHM, housingIHM, operation, choice);
                    break;
                case 2:
                    performOperation(foodIHM, electronicIHM, housingIHM, operation, choice);
                    break;
                case 3:
                    performOperation(foodIHM, electronicIHM, housingIHM, operation, choice);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
        em.close();
        emf.close();
    }

    private static void performOperation(ProductFoodIHM foodIHM, ProductElectronicIHM electronicIHM, ProductHousingIHM housingIHM, int operation, int choice) {
        switch (choice) {
            case 1:
                foodIHM.create();
                break;
            case 2:
                electronicIHM.create();
                break;
            case 3:
                housingIHM.create();
                break;
            default:
                System.out.println("Invalid operation.");
        }


    }
}