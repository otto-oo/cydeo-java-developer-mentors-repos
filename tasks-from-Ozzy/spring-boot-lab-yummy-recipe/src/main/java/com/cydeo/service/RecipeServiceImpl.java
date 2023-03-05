package com.cydeo.service;

import com.cydeo.model.Ingredients;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.cydeo.enums.QuantityType.*;
import static com.cydeo.enums.RecipeType.*;

@Component
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    private final ShareService shareService;

    private final static Faker FAKER = new Faker();

    @Override
    public boolean prepareRecipe() {
        int recipeType = random(10);
        Recipe recipe = new Recipe(
                UUID.randomUUID(),
                FAKER.food().dish(),
                random(100),
                random(100),
                prepareListIngredients(random(10)),
                (recipeType<2)?BREAKFAST:(recipeType<3)?LUNCH:(recipeType<4)?DESERT:(recipeType<5)?APPETIZER:(recipeType<6)?BAKED:
                        (recipeType<7)?SOUP:VEGETERIAN);

        boolean save = recipeRepository.save(recipe);
        shareService.shareRecipe(recipe);

        return save;
    }
    private static List<Ingredients> prepareListIngredients(int howManyIngredients){
        List<Ingredients> result = new ArrayList<>();
        for(int i = 0; i<howManyIngredients; i++){
            int quantityType = random(10);
            result.add(new Ingredients(FAKER.food().ingredient(), random(10), (quantityType<3)?LB:(quantityType<6)?OUNCE:TBSP ));
        }
        return result;
    }
    private static int random(int range){
        return (int)(Math.random()*range);
    }
}