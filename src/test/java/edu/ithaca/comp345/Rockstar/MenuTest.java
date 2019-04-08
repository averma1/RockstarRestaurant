package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    @Test
    public void menuCreateTest(){

        Stock stock = new Stock();
        Menu menu = new Menu("Spring Menu", stock);

        //check the name
       assertEquals("Spring Menu", menu.getName());

       //check that the stock and ingredients exist
       assertEquals(0, menu.getStock().getIngredientsList().size());

    }

    @Test
    public void addMenuItemTest(){

        //create the Ingredient objects
        Ingredient i1 = new Ingredient("chicken", 2.0, 301);
        Ingredient i2 = new Ingredient("fish", 3.40, 400);
        Ingredient i3 = new Ingredient("duck", 10.0, 30);

        //create the ArrayList of Ingredient objects and add the objects to the list
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(i1);
        ingredients.add(i2);
        ingredients.add(i3);

        //create a new Stock and Menu object
        Stock stock = new Stock();
        Menu menu = new Menu("Spring Menu", stock);

        //create a new MenuItem with the list of ingredients and add it to the menu
        MenuItem item = new MenuItem(ingredients, 4.0, "new dish");
        menu.addMenuItem(item);

        //test that everything in the menu exists
        assertEquals("New Dish", menu.getMenuItemMap().get("New Dish").getItemName());
        assertEquals(4.0, menu.getMenuItemMap().get("New Dish").getPrice());
        assertEquals("chicken", menu.getMenuItemMap().get("New Dish").getIngredients().get(0).getName());
        assertEquals("fish", menu.getMenuItemMap().get("New Dish").getIngredients().get(1).getName());
        assertEquals("duck", menu.getMenuItemMap().get("New Dish").getIngredients().get(2).getName());

    }

}
