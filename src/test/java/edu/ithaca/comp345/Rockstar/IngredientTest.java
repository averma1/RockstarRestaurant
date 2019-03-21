package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void isCostValidTest(){
        assertFalse(Ingredient.isCostValid(-1.0));
        assertFalse(Ingredient.isCostValid(-0.001));
        assertTrue(Ingredient.isCostValid(.001));
        assertTrue(Ingredient.isCostValid(1.0));
        assertTrue(Ingredient.isCostValid(1000));
    }

    @Test
    public void changeCostTest(){
        Ingredient ingredient = new Ingredient("onion", 1, 10);

        //check if cost is correct
        assertEquals(1,ingredient.getCost());

        //change cost
        ingredient.changeCost(2);

        //did it change?
        assertEquals(2,ingredient.getCost());

        //check if exception is thrown
        assertThrows(IllegalArgumentException.class, ()-> ingredient.changeCost(-0.01));
        assertThrows(IllegalArgumentException.class, ()-> ingredient.changeCost(-10));
    }

    @Test
    public void changeQuantityTest(){
        Ingredient ingredient = new Ingredient("onion", 1, 10);

        //check if quantity is correct
        assertEquals(10,ingredient.getQuantity());

        //change quantity
        ingredient.changeQuantity(40);

        //did it change?
        assertEquals(50,ingredient.getQuantity());

        //check is exception is thrown
        assertThrows(IllegalArgumentException.class, ()-> ingredient.changeQuantity(-10000));
        assertThrows(IllegalArgumentException.class, ()-> ingredient.changeQuantity(-51));

        ingredient.changeQuantity(-50);

        assertEquals(0,ingredient.getQuantity());


    }
}
