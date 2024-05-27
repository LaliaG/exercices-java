package org.example.Entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder

public class Meal {
    private int id_meal;
    private String description;
    private LocalDateTime date;
    private Animal animal;


}
