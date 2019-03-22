package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IngredientTest {
    @Test
    public void createIngredientTest(){
        Ingredient ingredient = new Ingredient("chicken", 2.0, 300);
        assertTrue(ingredient.getName().equals("chicken"));
        assertTrue(ingredient.getCost() == 2.0);
        assertTrue(ingredient.getQuantity() == 300);
    }

    @Test
    public void checkIfAvailableTest(){
        Ingredient ingredient = new Ingredient("onion", 1, 10);
        assertTrue(ingredient.checkIfAvailable(5));
        assertTrue(ingredient.checkIfAvailable(10));
        assertFalse(ingredient.checkIfAvailable(11));
    }
}
