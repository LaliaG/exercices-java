package org.example.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Comment {
    private int comment_id;
    private String comment_description;
    private int recipe_id;
}
