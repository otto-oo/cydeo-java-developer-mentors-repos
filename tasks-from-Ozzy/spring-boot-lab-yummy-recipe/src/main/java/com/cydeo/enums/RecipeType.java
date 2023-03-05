package com.cydeo.enums;

public enum RecipeType {

    BREAKFAST("Breakfast"), LUNCH("Lunch"), DESERT("Desert"), APPETIZER("Appetizer"),
    BAKED("Baked"), SOUP("Soup"), VEGETERIAN("Vegeterian");

    private String value;

    RecipeType(String value){
        this.value = value;
    }
}
