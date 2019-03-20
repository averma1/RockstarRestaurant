package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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






}
