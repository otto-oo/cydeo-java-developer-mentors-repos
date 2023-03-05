package com.cydeo.model;

import com.cydeo.enums.RecipeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private UUID id;
    private String name;
    private int duration;
    private int preparation;
    private List<Ingredients> ingredients;
    private RecipeType recipeType;

}

