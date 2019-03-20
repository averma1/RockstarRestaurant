package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IngredientTest {
    @Test
    public void createIngredientTest(){
        Ingredient ingredient = new Ingredient("chicken", 2.0, 300);
        assertTrue(ingredient.getName().equals("chicken"));
        assertTrue(ingredient.getCost() == 2.0);
        assertTrue(ingredient.getQuantity() == 300);
    }
}
