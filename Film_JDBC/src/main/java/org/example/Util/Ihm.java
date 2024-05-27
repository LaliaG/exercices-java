package org.example.Util;

import org.example.FilmDAO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Ihm {
    private Connection connection;
    private FilmDAO filmDAO;
    private Scanner scanner;
    public Ihm (){
        scanner = new Scanner(System.in);
        try{
            connection = DataBaseManager.getConnection();
            filmDAO = new FilmDAO(connection);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void start() {
        int entry ;
        while(true){
            System.out.println("--- Gestion de Film ---");
            System.out.println("1/ Creation de film");
            System.out.println("2/  Modifier le titre du film");
            System.out.println("3/ Supprimer un film");
            System.out.println("4/ Afficher tous les films ");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1 :
                    createFilm();
                    break;
                case 2 :
                    updateFilm();
                    break;
                case 3 :
                    deleteFilm();

                case 4 :
                    getAllFilms();
                    break;
                default:
                    return;
            }
        }
    }

    private void deleteFilm() {
    }

    private void updateFilm() {
    }

    private void getAllFilms() {
    }

    private void createFilm() {
    }
}
