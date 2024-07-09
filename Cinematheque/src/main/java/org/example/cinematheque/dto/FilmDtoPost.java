package org.example.cinematheque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDtoPost {
    private Long id;
    private String name;
    private String releaseDate;
    private String description;
    private int  duration;
    private String genre;
    private Long directorId;
}
