package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {

    @Test
    public void createMenuItemTest(){

        Ingredient i1 = new Ingredient("chicken", 1.00, 1);
        Ingredient i2 = new Ingredient("mushrooms", 2.20, 5);
        Ingredient i3 = new Ingredient("oregano", 0.50, 8);

        MenuItem item1 = new MenuItem("chicken dish", 25.00);
        item1.addIngredient(i1, 1);
        item1.addIngredient(i2, 1);
        item1.addIngredient(i3, 1);

        assertEquals(25.00, item1.getPrice());
        assertEquals("chicken dish", item1.getItemName());
    }

    @Test
    public void addIngredientTest(){

        Ingredient i1 = new Ingredient("chicken", 1.00, 1);
        Ingredient i2 = new Ingredient("mushrooms", 2.20, 5);
        Ingredient i3 = new Ingredient("oregano", 0.50, 8);


        MenuItem item1 = new MenuItem("chicken dish", 25.00);
        item1.addIngredient(i1, 1);
        item1.addIngredient(i2, 1);
        item1.addIngredient(i3, 1);

        //check that the current items are there
        assertEquals(3, item1.getIngredients().size());
        assertEquals("chicken", item1.getIngredients().get(0).getName());
        assertEquals("mushrooms", item1.getIngredients().get(1).getName());
        assertEquals("oregano", item1.getIngredients().get(2).getName());

        //ingredient to add
        Ingredient i4 = new Ingredient("pepper", 0.2, 3);

        //add the ingredient
        item1.addIngredient(i4, 1);

        //check that all the items are there
        assertEquals(4, item1.getIngredients().size());
        assertEquals("chicken", item1.getIngredients().get(0).getName());
        assertEquals("mushrooms", item1.getIngredients().get(1).getName());
        assertEquals("oregano", item1.getIngredients().get(2).getName());
        assertEquals("pepper", item1.getIngredients().get(3).getName());
    }

    @Test
    public void removeIngredientTest(){

        Ingredient i1 = new Ingredient("chicken", 1.00, 1);
        Ingredient i2 = new Ingredient("mushrooms", 2.20, 5);
        Ingredient i3 = new Ingredient("oregano", 0.50, 8);

        MenuItem item1 = new MenuItem("chicken dish", 25.00);
        item1.addIngredient(i1, 1);
        item1.addIngredient(i2, 1);
        item1.addIngredient(i3, 1);

        //check that the current items are there
        assertEquals(3, item1.getIngredients().size());
        assertEquals("chicken", item1.getIngredients().get(0).getName());
        assertEquals("mushrooms", item1.getIngredients().get(1).getName());
        assertEquals("oregano", item1.getIngredients().get(2).getName());

        //remove the ingredient
        item1.removeIngredient(i2);

        //check that the correct items are there
        assertEquals(2, item1.getIngredients().size());
        assertEquals("chicken", item1.getIngredients().get(0).getName());
        assertEquals("oregano", item1.getIngredients().get(1).getName());

    }

    @Test
    public void changePriceTest(){

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        MenuItem item1 = new MenuItem("chicken dish", 25.00);

        assertEquals(25.00, item1.getPrice());

        //change the price
        item1.changePrice(12.40);

        //check if the price changed
        assertEquals(12.40, item1.getPrice());

    }

}
