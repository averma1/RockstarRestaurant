package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.util.*;

public class StockTest {

    @Test
    public void createStockTest(){
        Stock stock = new Stock();
        assertEquals(0, stock.getIngredientsList().size());
    }

    @Test
    public void removeMenuItem(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);
        stock.addIngredient("fish", 8.34, 23);
        stock.addIngredient("mouse", .34, 400);

        MenuItem item= new MenuItem("fish stew", 12.05);
        item.addIngredient(stock.getIngredient("fish"), 3);
        stock.removeMenuItem(item);
        assertEquals(20, stock.getQuantity("fish"));

        MenuItem item2= new MenuItem("a really weird bagel", 12.05);
        item2.addIngredient(stock.getIngredient("mouse"), 100);
        item2.addIngredient(stock.getIngredient("fish"), 5);
        item2.addIngredient(stock.getIngredient("chicken"), 50);
        stock.removeMenuItem(item2);
        assertEquals(15, stock.getQuantity("fish"));
        assertEquals(50, stock.getQuantity("chicken"));
        assertEquals(300, stock.getQuantity("mouse"));
    }

    @Test
    public void removeSeveralIngredientsTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);
        stock.addIngredient("fish", 8.34, 20);
        stock.addIngredient("mouse", .34, 400);
        stock.removeSeveralIngredients("fish", 5);
        stock.removeSeveralIngredients("chicken", 50);
        stock.removeSeveralIngredients("mouse", 100);
        assertEquals(15, stock.getQuantity("fish"));
        assertEquals(50, stock.getQuantity("chicken"));
        assertEquals(300, stock.getQuantity("mouse"));

        //assertThrows(InaccessibleObjectException.class, ()->{ stock.removeSeveralIngredients("fish", 200); });
        //assertThrows(InaccessibleObjectException.class, ()->{ stock.removeSeveralIngredients("cabbage", 200); });
    }

    @Test
    public void addIngredientTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);
        stock.addIngredient("fish", 8.34, 23);
        stock.addIngredient("mouse", .34, 400);

        //check that the chicken is there
        assertTrue(stock.getIngredientsList().containsKey("chicken"));
        assertEquals("chicken", stock.getIngredient("chicken").getName());
        assertEquals(2.0, stock.getIngredient("chicken").getCost());
        assertEquals(100, stock.getIngredient("chicken").getQuantity());

        //check that the fish is there
        assertTrue(stock.getIngredientsList().containsKey("fish"));
        assertEquals("fish", stock.getIngredient("fish").getName());
        assertEquals(8.34, stock.getIngredient("fish").getCost());
        assertEquals(23, stock.getIngredient("fish").getQuantity());

        //check that the mouse is there
        assertTrue(stock.getIngredientsList().containsKey("mouse"));
        assertEquals("mouse", stock.getIngredient("mouse").getName());
        assertEquals(.34, stock.getIngredient("mouse").getCost());
        assertEquals(400, stock.getIngredient("mouse").getQuantity());

    }

    @Test
    public void getCostTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);
        stock.addIngredient("fish", 8.34, 23);
        stock.addIngredient("mouse", .34, 400);

        assertEquals(2.0, stock.getCost("chicken"));
        assertEquals(8.34, stock.getCost("fish"));
        assertEquals(0.34, stock.getCost("mouse"));
    }

    @Test
    public void getQuantityTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);
        stock.addIngredient("fish", 8.34, 23);
        stock.addIngredient("mouse", .34, 400);

        assertEquals(100, stock.getQuantity("chicken"));
        assertEquals(23, stock.getQuantity("fish"));
        assertEquals(400, stock.getQuantity("mouse"));
    }

    @Test
    public void removeIngredientTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);
        stock.addIngredient("fish", 8.34, 23);
        stock.addIngredient("mouse", .34, 400);

        //check that the fish is there
        assertTrue(stock.getIngredientsList().containsKey("fish"));
        assertEquals("fish", stock.getIngredient("fish").getName());
        assertEquals(8.34, stock.getIngredient("fish").getCost());
        assertEquals(23, stock.getIngredient("fish").getQuantity());

        //remove the fish
        stock.removeIngredient("fish");

        //check that the fish is gone
        assertFalse(stock.getIngredientsList().containsKey("fish"));

    }


    @Test
    public void changeIngredientNameTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);

        assertTrue(stock.getIngredientsList().containsKey("chicken"));
        assertEquals("chicken", stock.getIngredient("chicken").getName());

        stock.changeIngredientName("chicken", "fish");
        assertFalse(stock.getIngredientsList().containsKey("chicken"));
        assertTrue(stock.getIngredientsList().containsKey("fish"));
    }

    @Test
    public void changeIngredientCostTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);

        assertTrue(stock.getIngredientsList().containsKey("chicken"));

        assertEquals(2.0, stock.getIngredient("chicken").getCost());
        stock.changeIngredientCost("chicken", 4.4);

        assertEquals(4.4, stock.getIngredient("chicken").getCost());
    }

    @Test
    public void changeIngredientQuantityTest(){
        Stock stock = new Stock();
        stock.addIngredient("chicken", 2.0, 100);

        assertTrue(stock.getIngredientsList().containsKey("chicken"));

        assertEquals(100, stock.getIngredient("chicken").getQuantity());
        stock.changeIngredientQuantity("chicken", 200);

        assertEquals(200, stock.getIngredient("chicken").getQuantity());
    }

    @Test
    public void loadStockFromFileTest()throws IOException {

        //Load in 3 ingredient to an empty stock from file
        Stock stock = new Stock();
        stock.loadFromFile("stockTestFile1.txt");
        assertTrue(stock.isIngredientAvailable("chicken"));
        assertTrue(stock.getQuantity("chicken") == 40);
        assertTrue(stock.getCost("chicken") == 3.5);
        assertTrue(stock.isIngredientAvailable("onion"));
        assertTrue(stock.getQuantity("onion") == 20);
        assertTrue(stock.getCost("onion") == 1.5);
        assertTrue(stock.isIngredientAvailable("pepper"));
        assertTrue(stock.getQuantity("pepper") == 30);
        assertTrue(stock.getCost("pepper") == 2);

        //add ingredients that already exist in stock from a file
        stock.loadFromFile("stockTestFile1.txt");
        assertTrue(stock.isIngredientAvailable("chicken"));
        assertTrue(stock.getQuantity("chicken") == 80);
        assertTrue(stock.getCost("chicken") == 3.5);
        assertTrue(stock.isIngredientAvailable("onion"));
        assertTrue(stock.getQuantity("onion") == 40);
        assertTrue(stock.getCost("onion") == 1.5);
        assertTrue(stock.isIngredientAvailable("pepper"));
        assertTrue(stock.getQuantity("pepper") == 60);
        assertTrue(stock.getCost("pepper") == 2);
        assertFalse(stock.getQuantity("chicken") == 35);

        //load a slightly invalid stock file
        //the file should successfully add 5 chicken, but fail to add anything else due to incorrect formatting
        stock.loadFromFile("stockTestFile2.txt");
        assertTrue(stock.getQuantity("chicken") == 85);
        assertTrue(stock.getQuantity("onion") == 40);
        assertTrue(stock.getQuantity("pepper") == 60);

        //bad file name
        //assertThrows(FileNotFoundException.class, ()-> stock.loadFromFile("thisIsNotAFile.txt"));
    }

    @Test
    public void saveStockToFileTest()throws IOException {

        //Load in 3 ingredient to an empty stock from file and test to see that they exist
        Stock stock = new Stock();
        stock.loadFromFile("stockTestFile1.txt");
        assertTrue(stock.isIngredientAvailable("chicken"));
        assertTrue(stock.getQuantity("chicken") == 40);
        assertTrue(stock.getCost("chicken") == 3.5);
        assertTrue(stock.isIngredientAvailable("onion"));
        assertTrue(stock.getQuantity("onion") == 20);
        assertTrue(stock.getCost("onion") == 1.5);
        assertTrue(stock.isIngredientAvailable("pepper"));
        assertTrue(stock.getQuantity("pepper") == 30);
        assertTrue(stock.getCost("pepper") == 2);

        HashMap<String, Ingredient> originalMap = stock.getIngredientsList();

        //save the current stock to the new file
        stock.saveStockToFile("stockOutputTest.txt");

        Stock stock2 = new Stock();
        stock2.loadFromFile("stockOutputTest.txt");

        HashMap<String, Ingredient> newMap = stock2.getIngredientsList();

        //a collection of the original map
        Collection<Ingredient> collection = originalMap.values();
        Iterator<Ingredient> iterator = collection.iterator();

        //check going both ways to make sure the keys of one map are present as the names of objects in the other
        Ingredient current = null;
        while (iterator.hasNext()) {
            current = iterator.next();
            assertTrue(newMap.containsKey(current.getName()));
        }

        //a collection of the new map
        Collection<Ingredient> collection2 = newMap.values();
        Iterator<Ingredient> iterator2 = collection2.iterator();

        current = null;
        while (iterator2.hasNext()) {
            current = iterator2.next();
            assertTrue(originalMap.containsKey(current.getName()));
        }
    }


}
