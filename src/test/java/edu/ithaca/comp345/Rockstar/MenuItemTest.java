package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuItemTest {

    @Test
    public void createMenuItemTest(){

        Ingredient i1 = new Ingredient("chicken", 1.00, 1);
        Ingredient i2 = new Ingredient("mushrooms", 2.20, 5);
        Ingredient i3 = new Ingredient("oregano", 0.50, 8);

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        MenuItem item1 = new MenuItem(ingredients, 25.00, "chicken dish");

        assertEquals(25.00, item1.getPrice());
        assertEquals("chicken dish", item1.getItemName());
        assertEquals(ingredients, item1.getIngredients());

    }

}
