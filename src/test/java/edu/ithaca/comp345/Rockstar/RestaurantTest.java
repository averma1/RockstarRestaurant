package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    @Test
    public void getAndSetNameTest(){
        Restaurant testRest = new Restaurant("Saigon Kitchen");
        assertTrue(testRest.getName()=="Saigon Kitchen");
        assertFalse(testRest.getName()!="Saigon Kitchen");

        testRest.setName("Luna");
        assertTrue(testRest.getName()=="Luna");
        assertFalse(testRest.getName()!="Luna");
    }

    @Test
    public void waiterPlaceOrderTest(){
        //should read a file and create a menu, stock, and tables
        Restaurant main= new Restaurant("test.txt", 1);
        main.host.seatCustomers(2, 4);
        MenuItem item1= main.menu.getMenuItem("chicken parm");
        MenuItem item2= main.menu.getMenuItem("cheese ravioli");
        MenuItem item3= main.menu.getMenuItem("bread sticks");
        MenuItem item4= main.menu.getMenuItem("coffee");
        MenuItem item5= main.menu.getMenuItem("chocolate cake");
        MenuItem item6= main.menu.getMenuItem("beer");
        main.waiter.takeOrder(item1, 2, 1);
        main.waiter.takeOrder(item2, 2, 2);
        main.waiter.takeOrder(item3, 2, 3);
        main.waiter.takeOrder(item4, 2, 4);
        main.waiter.takeOrder(item5, 2, 2);
        main.waiter.takeOrder(item6, 2, 3);
        assertEquals(15, main.stock.getQuantity("ravioli"));
        assertEquals(50, main.stock.getQuantity("chicken"));
        assertEquals(300, main.stock.getQuantity("breadSticks"));
        assertEquals(60.00, main.waiter.payTotalBill(2));
        main.saveToFile("test.txt");
    }
/*
    @Test
    public void bartenderPlaceOrderTest(){
        //should read a file and create a menu, stock, create bar, and tables
        Restaurant main= new Restaurant("test.txt", 1);
        MenuItem item1= main.bartender.barMenu.getMenuItem("margarita");
        MenuItem item2= main.bartender.barMenu.getMenuItem("red wine");
        MenuItem item3= main.bartender.barMenu.getMenuItem("soup");
        MenuItem item4= main.bartender.barMenu.getMenuItem("coffee");
        MenuItem item5= main.bartender.barMenu.getMenuItem("mojito");
        MenuItem item6= main.bartender.barMenu.getMenuItem("beer");
        main.bartender.addToOrder(1, item1);
        main.bartender.addToOrder(1, item2);
        main.bartender.addToOrder(4, item3);
        main.bartender.addToOrder(4, item4);
        main.bartender.addToOrder(8, item5);
        main.bartender.addToOrder(2, item6);
        assertEquals(15, main.bartender.barStock.getQuantity("tequila"));
        assertEquals(50, main.bartender.barStock.getQuantity("beer"));
        assertEquals(300, main.bartender.barStock.getQuantity("soup"));
        assertEquals(10.00, main.bartender.pay(8));
        Table bar= main.allTables.get(main.findTable(main.bartender.getBar()));
        assertEquals(3, bar.orders.size());
        assertEquals(-1, bar.findOrder(8));
        main.saveToFile("test.txt");
    }
    */
}
