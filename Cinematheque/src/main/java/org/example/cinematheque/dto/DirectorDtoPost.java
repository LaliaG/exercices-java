package org.example.cinematheque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDtoPost {
    private Long id;

    private String firstName;
    private String lastName;
    private String birthDate;
    private String nationality;
}
