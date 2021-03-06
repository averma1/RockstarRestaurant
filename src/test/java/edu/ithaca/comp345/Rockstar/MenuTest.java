package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.testng.Assert.assertEquals;

public class MenuTest {

    @Test
    public void menuCreateTest(){

        Stock stock = new Stock();
        Menu menu = new Menu("Spring Menu", stock);

        //check the name
       Assertions.assertEquals("Spring Menu", menu.getName());

       //check that the stock and ingredients exist
       Assertions.assertEquals(0, menu.getStock().getIngredientsList().size());

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
        MenuItem item = new MenuItem("new dish", 4.0);
        item.addIngredient(i1, 1);
        item.addIngredient(i2, 1);
        item.addIngredient(i3, 1);
        menu.addMenuItem(item);

        //test that everything in the menu exists
        Assertions.assertEquals("new dish", menu.getMenuItemMap().get("new dish").getItemName());
        Assertions.assertEquals(4.0, menu.getMenuItemMap().get("new dish").getPrice());
        Assertions.assertEquals("chicken", menu.getMenuItemMap().get("new dish").getIngredient("chicken").getName());
        Assertions.assertEquals("fish", menu.getMenuItemMap().get("new dish").getIngredient("fish").getName());
        Assertions.assertEquals("duck", menu.getMenuItemMap().get("new dish").getIngredient("duck").getName());

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
        MenuItem item = new MenuItem("new dish", 4.0);
        item.addIngredient(i1, 1);
        item.addIngredient(i2, 1);
        item.addIngredient(i3, 1);
        MenuItem item2 = new MenuItem("the other dish", 4.3);
        item2.addIngredient(i1, 1);
        item2.addIngredient(i2, 1);
        item2.addIngredient(i3, 1);
        MenuItem item3 = new MenuItem("the best dish", 4.3);
        item3.addIngredient(i1, 1);
        item3.addIngredient(i2, 1);
        item3.addIngredient(i3, 1);

        menu.addMenuItem(item);
        menu.addMenuItem(item2);
        menu.addMenuItem(item3);

        //verify the MenuItem exist
        assertTrue(menu.getMenuItemMap().containsKey("new dish"));
        assertTrue( menu.getMenuItemMap().containsKey("the other dish"));
        assertTrue(menu.getMenuItemMap().containsKey("the best dish"));

        //remove an item
        menu.removeMenuItem("the other dish");

        //verify the MenuItem was removed
        assertTrue(menu.getMenuItemMap().containsKey("new dish"));
        assertFalse(menu.getMenuItemMap().containsKey("the other dish"));
        assertTrue(menu.getMenuItemMap().containsKey("the best dish"));

        //check that the exception is thrown
        assertThrows(IllegalArgumentException.class, ()-> menu.removeMenuItem("not in the map"));
        assertThrows(IllegalArgumentException.class, ()-> menu.removeMenuItem(""));

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
        MenuItem item = new MenuItem("new dish", 4.0);
        item.addIngredient(i1, 1);
        item.addIngredient(i2, 1);
        item.addIngredient(i3, 1);
        MenuItem item2 = new MenuItem("the other dish", 4.3);
        item2.addIngredient(i1, 1);
        item2.addIngredient(i2, 1);
        item2.addIngredient(i3, 1);
        MenuItem item3 = new MenuItem("the best dish", 4.3);
        item3.addIngredient(i1, 1);
        item3.addIngredient(i2, 1);
        item3.addIngredient(i3, 1);

        menu.addMenuItem(item);
        menu.addMenuItem(item2);
        menu.addMenuItem(item3);

        //check to see if we found the correct menu item
        MenuItem menuItem = menu.getMenuItem("the other dish");

        Assertions.assertEquals("the other dish", menuItem.getItemName());
        Assertions.assertEquals(4.3, menuItem.getPrice());
        Assertions.assertEquals("chicken", menu.getMenuItemMap().get("the other dish").getIngredient("chicken").getName());
        Assertions.assertEquals("fish", menu.getMenuItemMap().get("the other dish").getIngredient("fish").getName());
        Assertions.assertEquals("duck", menu.getMenuItemMap().get("the other dish").getIngredient("duck").getName());

        //check that the exception is thrown
        assertThrows(IllegalArgumentException.class, ()-> menu.getMenuItem("not in the map"));
        assertThrows(IllegalArgumentException.class, ()-> menu.getMenuItem(""));


    }

    @Test
    public void isNameValidTest(){

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
        MenuItem item = new MenuItem("new dish", 4.0);
        item.addIngredient(i1, 1);
        item.addIngredient(i2, 1);
        item.addIngredient(i3, 1);
        MenuItem item2 = new MenuItem("the other dish", 4.3);
        item2.addIngredient(i1, 1);
        item2.addIngredient(i2, 1);
        item2.addIngredient(i3, 1);
        MenuItem item3 = new MenuItem("the best dish", 4.3);
        item3.addIngredient(i1, 1);
        item3.addIngredient(i2, 1);
        item3.addIngredient(i3, 1);

        menu.addMenuItem(item);
        menu.addMenuItem(item2);
        menu.addMenuItem(item3);

        //check if the name is valid
        assertTrue(menu.isNameValid("new dish"));
        assertTrue(menu.isNameValid("the other dish"));
        assertTrue(menu.isNameValid("the best dish"));

        assertFalse(menu.isNameValid("a dish"));
        assertFalse(menu.isNameValid(""));

    }

    @Test
    public void loadMenuFromFile() throws IOException{
        //set up a menu and stock
        Stock myStock = new Stock();
        myStock.loadFromFile("stockTestFile3.txt");
        Menu myMenu = new Menu("Test Menu", myStock);

        //load in from file
        myMenu.loadMenuFromFile("menuTestFile1.txt");

        //check if the menuItems are in the menu
        assertEquals("Chicken Parm", myMenu.getMenuItem("Chicken Parm").getItemName());
        assertEquals("Cheese Burger", myMenu.getMenuItem("Cheese Burger").getItemName());

        //get ingredients from the menu
        ArrayList<Ingredient> chickenParmIngredients = myMenu.getMenuItem("Chicken Parm").getIngredients();
        assertTrue(chickenParmIngredients.contains(myStock.getIngredient("chicken")));
        assertTrue(chickenParmIngredients.contains(myStock.getIngredient("cheese")));
        assertTrue(chickenParmIngredients.contains(myStock.getIngredient("sauce")));

        //check that nonexistent items do not exist
        assertThrows(IllegalArgumentException.class,()-> myMenu.getMenuItem("Beef Stew"));
    }


    @Test
    public void saveMenuToFileTest() throws IOException{

        Stock myStock = new Stock();
        myStock.loadFromFile("stockTestFile3.txt");
        Menu myMenu = new Menu("Test Menu", myStock);

        Stock myStock2 = new Stock();
        myStock.loadFromFile("stockTestFile3.txt");
        Menu myMenu2 = new Menu("Test Menu 2", myStock2);



        myMenu.loadMenuFromFile("menuTestFile1.txt");

        myMenu.saveMenuToFile("menuOutputFile.txt");

        myMenu2.loadMenuFromFile("menuOutputFile.txt");



        HashMap<String, MenuItem> map1 = myMenu.getMenuItemMap();

        HashMap<String, MenuItem> map2 = myMenu2.getMenuItemMap();

        //a collection of the original map
        Collection<MenuItem> collection = map1.values();
        Iterator<MenuItem> iterator = collection.iterator();

        //check going both ways to make sure the keys of one map are present as the names of objects in the other
        MenuItem current = null;
        while (iterator.hasNext()) {
            current = iterator.next();
            assertTrue(map2.containsKey(current.getItemName()));
        }

        //a collection of the new map
        Collection<MenuItem> collection2 = map2.values();
        Iterator<MenuItem> iterator2 = collection2.iterator();

        current = null;
        while (iterator2.hasNext()) {
            current = iterator2.next();
            assertTrue(map1.containsKey(current.getItemName()));
        }


    }

}
