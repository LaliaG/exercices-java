package org.example.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeIngredient {
    private int id;
    private int quantity;
    private int recipe_id;
    private int ingredient_id;
}
