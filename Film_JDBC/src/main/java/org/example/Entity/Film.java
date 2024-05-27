package org.example.Entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
@Data
@Builder

public class Film {
    private int id_film;
    private String titre;
    private String realisateur;
    private LocalDate dateSortie;
    private String genre;

    @Override
    public String toString() {
        return "Film{" +
                "id_film=" + id_film +
                ", titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateSortie=" + dateSortie +
                ", genre='" + genre + '\'' +
                '}';
    }
}
