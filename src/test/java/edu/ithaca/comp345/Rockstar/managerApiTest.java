package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class managerApiTest {

    @Test
    public void addAndGetIngredientTest(){
        //add Ingredients


        managerApi.addIngredient("chicken", 9.50, 30);
        managerApi.addIngredient("potatoes", 1.30, 50);
        managerApi.addIngredient("onion", 2.00, 20);

        //test getIngredient
        Ingredient testIngredient1 = managerApi.getIngredient("chicken");
        Ingredient testIngredient2 = managerApi.getIngredient("potatoes");
        Ingredient testIngredient3 = managerApi.getIngredient("pickels");

        assertTrue(testIngredient1.getName() == "chicken");
        assertTrue(testIngredient1.getQuantity() == 30);
        assertTrue(testIngredient1.getCost() == 9.5);
    }

    @Test
    public void checkIfAvailableAndRemoveIngredientTest(){
        //add Ingredients
        managerApi.addIngredient("chicken", 9.50, 30);
        managerApi.addIngredient("potatoes", 1.30, 50);
        managerApi.addIngredient("onion", 2.00, 20);

        //check if Available
        assertTrue(managerApi.isIngredientAvailable("chicken"));
        assertFalse(managerApi.isIngredientAvailable("pickels"));
        //remove Ingredients
        managerApi.removeIngredient("chicken");

        //check if Available
        assertFalse(managerApi.isIngredientAvailable("chicken"));
    }


}
