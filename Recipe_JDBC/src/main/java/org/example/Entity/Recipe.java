package org.example.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder

public class Recipe {
    private int recipe_id;
    private String recipe_name;
    private int prepTime;
    private int cookTime;
    private int difficulty;
    private List<Ingredient> ingredients;
    private List<Step> steps;
    private List<Comment> comments;
    private Category category;
}
