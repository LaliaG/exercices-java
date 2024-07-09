package org.example.cinematheque.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmDtoGet {
    private Long id;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private int  duration;
    private String genre;
    private DirectorDtoGet director;
}
