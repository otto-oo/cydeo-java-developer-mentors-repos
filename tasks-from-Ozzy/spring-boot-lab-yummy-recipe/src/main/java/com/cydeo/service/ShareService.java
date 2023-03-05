package com.cydeo.service;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

public interface ShareService {

    void shareRecipe(Recipe recipe);
}

