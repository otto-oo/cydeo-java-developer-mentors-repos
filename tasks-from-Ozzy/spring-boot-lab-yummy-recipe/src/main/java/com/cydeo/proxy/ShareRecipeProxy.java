package com.cydeo.proxy;

import com.cydeo.model.Recipe;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

public interface ShareRecipeProxy {
    void shareRecipe(Recipe recipe);
}

