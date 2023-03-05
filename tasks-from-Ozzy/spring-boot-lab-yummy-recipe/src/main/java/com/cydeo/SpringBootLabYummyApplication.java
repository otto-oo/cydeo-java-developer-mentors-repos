package com.cydeo;

import com.cydeo.model.Recipe;
import com.cydeo.enums.RecipeType;
import com.cydeo.service.RecipeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootLabYummyApplication {

    public static void main(String[] args) {

        ApplicationContext container =  SpringApplication.run(SpringBootLabYummyApplication.class, args);

//        Recipe recipe=new Recipe();
//        recipe.setName("Blue Cheese Stuffed Tomatoes");
//        recipe.setRecipeType(RecipeType.APPETIZER);
//        RecipeService recipeService=container.getBean(RecipeService.class);
//        recipeService.prepareRecipe(recipe);
//
//        recipeService.printDbRecipeConfigData();//Chuck

        for(int i = 0 ; i< 5; i++)
            container.getBean(RecipeService.class).prepareRecipe();

    }

}
