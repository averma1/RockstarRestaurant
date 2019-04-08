package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

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

}
