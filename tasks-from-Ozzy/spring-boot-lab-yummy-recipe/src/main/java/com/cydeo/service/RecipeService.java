package com.cydeo.service;

import com.cydeo.config.DBRecipeConfigData;
import com.cydeo.model.Recipe;
import com.cydeo.proxy.ShareRecipeProxy;
import com.cydeo.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface RecipeService {

    boolean prepareRecipe();


//    private final ShareRecipeProxy shareRecipeProxy;
//    private final RecipeRepository recipeSaveRepository;
//    private final DBRecipeConfigData dbRecipeConfigData;
//
//    public RecipeService(DBRecipeConfigData dbRecipeConfigData,ShareRecipeProxy shareRecipeProxy, RecipeRepository recipeSaveRepository) {
//        this.dbRecipeConfigData = dbRecipeConfigData;
//        this.shareRecipeProxy = shareRecipeProxy;
//        this.recipeSaveRepository = recipeSaveRepository;
//    }
//
//    public void prepareRecipe(Recipe recipe) {
//        List<Recipe> list = new ArrayList<>();
//        Faker faker=new Faker();
//        //  Random random=new Random();//I couldnt use random???
//        for (int i = 0; i <5; i++) {
//            System.out.println(faker.food().ingredient());
//        }
//
//        recipeSaveRepository.save(recipe);
//        shareRecipeProxy.shareRecipe(recipe);
//
//    }
//    public void printDbRecipeConfigData(){
//        System.out.println(dbRecipeConfigData.getName());
//
//    }

}
