package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void removeMenuItemTest(){

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

        //create new MenuItems with the list of ingredients and add them to the menu
        MenuItem item = new MenuItem(ingredients, 4.0, "new dish");
        MenuItem item2 = new MenuItem(ingredients, 4.3, "the other dish");
        MenuItem item3 = new MenuItem(ingredients, 4.3, "the best dish");
        menu.addMenuItem(item);
        menu.addMenuItem(item2);
        menu.addMenuItem(item3);

        //verify the MenuItem exist
        assertTrue(menu.getMenuItemMap().containsKey("New Dish"));
        assertTrue( menu.getMenuItemMap().containsKey("the other dish"));
        assertTrue(menu.getMenuItemMap().containsKey("the best dish"));

        //remove an item
        menu.removeMenuItem("the other dish");

        //verify the MenuItem was removed
        assertTrue(menu.getMenuItemMap().containsKey("New Dish"));
        assertFalse(menu.getMenuItemMap().containsKey("the other dish"));
        assertTrue(menu.getMenuItemMap().containsKey("the best dish"));

    }

    @Test
    public void getMenuItemTest(){

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

        //create new MenuItems with the list of ingredients and add them to the menu
        MenuItem item = new MenuItem(ingredients, 4.0, "new dish");
        MenuItem item2 = new MenuItem(ingredients, 4.3, "the other dish");
        MenuItem item3 = new MenuItem(ingredients, 4.3, "the best dish");
        menu.addMenuItem(item);
        menu.addMenuItem(item2);
        menu.addMenuItem(item3);

        //check to see if we found the correct menu item
        MenuItem menuItem = menu.getMenuItem("the other dish");

        assertEquals("the other dish", menuItem.getItemName());
        assertEquals(4.3, menuItem.getPrice());
        assertEquals("chicken", menu.getMenuItemMap().get("the other dish").getIngredients().get(0).getName());
        assertEquals("fish", menu.getMenuItemMap().get("the other dish").getIngredients().get(1).getName());
        assertEquals("duck", menu.getMenuItemMap().get("the other dish").getIngredients().get(2).getName());


    }





}
