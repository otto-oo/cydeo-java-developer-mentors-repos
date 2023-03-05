package com.cydeo.repository;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

import static com.cydeo.bootstrap.StaticConstants.RECIPE_LIST;

@Component
public class RecipeRepositoryImpl implements RecipeRepository {
    @Override
    public boolean save(Recipe recipe) {
        System.out.println("Stored recipe" );
        return RECIPE_LIST.add(recipe);
    }
}
