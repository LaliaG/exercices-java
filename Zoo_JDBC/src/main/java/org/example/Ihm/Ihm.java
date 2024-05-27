package org.example.Ihm;

import org.example.DAO.AnimalDAO;
import org.example.DAO.MealDAO;
import org.example.Entity.Animal;
import org.example.Entity.Meal;
import org.example.Util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private Connection connection;
    private AnimalDAO animalDAO;
    private MealDAO mealDAO;
    private Scanner scanner;
    public Ihm (){
        scanner = new Scanner(System.in);
        try{
            connection = DatabaseManager.getConnection();
            animalDAO = new AnimalDAO(connection);
            mealDAO = new MealDAO(connection,mealDAO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void start (){
        int entry ;
        while (true){
            System.out.println("--- Gestion d'un Zoo ---");
            System.out.println("1/ Ajouter un animal");
            System.out.println("2/ Afficher tous les animaux");
            System.out.println("3/ Enregistrer un repas pour un animal spécifique");
            System.out.println("4/ Rechercher un animal par son id, son nom, sa race, habitat ou son age");
            entry = scanner.nextInt();
            scanner.nextLine();
            
            switch (entry){
                case 1 : 
                    addAnimal();
                    break;
                case 2 : 
                    getAllAnimals();
                    break;
                case 3 :
                    saveMealByIdAnimal();
                    break;
                case 4 :
                    searchById();
                    break;
                default:
                    return;
                    
            }
        }
    }

    private void addAnimal() {
        System.out.println("--- creation d'animal ---");
        System.out.println("nom de l'animal :");
        String name = scanner.nextLine();
        System.out.println("race de l'animal:");
        String race = scanner.nextLine();
        System.out.println("description de l'animal :");
        String description = scanner.nextLine();
        System.out.println("habitat de l'animal :");
        String habitat = scanner.nextLine();
        System.out.println("age de l'animal :");
        int age =  scanner.nextInt();
        scanner.nextLine();

        try{

            Animal animal =animalDAO.save(Animal.builder().name(name).race(race).description(description).habitat(habitat).age(age).build());
            System.out.println("l'animal a ete ajouté" + animal);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void getAllAnimals() {
        System.out.println("--- Affichage de tous les animaux ---");
        try {
            List<Animal> animals = animalDAO.getAll();
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveMealByIdAnimal() {
        System.out.println("--- Enregistrement d'un repas pour un animal spécifique ---");
        System.out.println("ID de l'animal : ");
        int animalId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Détails du repas : ");
        String details = scanner.nextLine();
        try {
            Animal animal = animalDAO.getById(animalId);
            // Création du repas avec la date
            LocalDateTime dateTime = LocalDateTime.now();
            Meal meal = new Meal(id_animal, dateTime, details);
            mealDAO.save(meal);
            System.out.println("Repas enregistré pour l'animal : " + animal.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchById() {
        System.out.println("--- Recherche d'un animal ---");
        System.out.println("Entrez le critère de recherche :");
        System.out.println("1. Recherche par ID");
        System.out.println("2. Recherche par nom");
        System.out.println("3. Recherche par race");
        System.out.println("4. Recherche par habitat");
        System.out.println("5. Recherche par âge");
        System.out.println("Choix : ");

        int choice = scanner.nextInt();
        scanner.nextLine();


        try {
            switch (choice) {
                case 1:
                    System.out.println("Entrez l'ID de l'animal :");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Animal animalById = animalDAO.getById(id);
                    System.out.println("Résultat de la recherche : " + animalById);
                    break;
                case 2:
                    System.out.println("Entrez le nom de l'animal :");
                    String name = scanner.nextLine();
                    List<Animal> animalsByName = animalDAO.getByName(name);
                    System.out.println("Résultat de la recherche : ");
                    for (Animal animal : animalsByName) {
                        System.out.println(animal);
                    }
                    break;
                case 3:
                    System.out.println("Entrez la race de l'animal :");
                    String race = scanner.nextLine();
                    List<Animal> animalsByRace = animalDAO.getByRace(race);
                    System.out.println("Résultat de la recherche : ");
                    for (Animal animal : animalsByRace) {
                        System.out.println(animal);
                    }
                    break;
                case 4:
                    System.out.println("Entrez l'habitat de l'animal :");
                    String habitat = scanner.nextLine();
                    List<Animal> animalsByHabitat = animalDAO.getByHabitat(habitat);
                    System.out.println("Résultat de la recherche : ");
                    for (Animal animal : animalsByHabitat) {
                        System.out.println(animal);
                    }
                    break;
                case 5:
                    System.out.println("Entrez l'âge de l'animal :");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    List<Animal> animalsByAge = animalDAO.getByAge(age);
                    System.out.println("Résultat de la recherche : ");
                    for (Animal animal : animalsByAge) {
                        System.out.println(animal);
                    }
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
