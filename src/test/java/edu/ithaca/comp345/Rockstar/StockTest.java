package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class StockTest {

    @Test
    public void createStockTest(){
        Stock stock = new Stock();
        assertEquals(0, stock.getIngredientsList().size());
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
        assertThrows(FileNotFoundException.class, ()-> stock.loadFromFile("thisIsNotAFile.txt"));
    }


}
