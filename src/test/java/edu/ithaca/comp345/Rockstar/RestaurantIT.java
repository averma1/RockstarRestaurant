package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantIT {

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
        assertEquals(57.47, main.waiter.payTotalBill(1));
        //check that stock is lowered somehow?
    }

    @Test
    public void bartenderPlaceOrderTest(){
        //should read a file and create a menu, stock, create bar, and tables
        Restaurant main= new Restaurant("test.txt", 1);
        MenuItem item1= main.bartender.menu.getMenuItem("margarita");
        MenuItem item2= main.bartender.menu.getMenuItem("red wine");
        MenuItem item3= main.bartender.menu.getMenuItem("soup");
        MenuItem item4= main.bartender.menu.getMenuItem("coffee");
        MenuItem item5= main.bartender.menu.getMenuItem("mojito");
        MenuItem item6= main.bartender.menu.getMenuItem("beer");
        main.bartender.createOrder(1);
        main.bartender.addToOrder(1, item1);
        main.bartender.addToOrder(1, item2);
        main.bartender.createOrder(4);
        main.bartender.addToOrder(4, item3);
        main.bartender.addToOrder(4, item4);
        main.bartender.createOrder(8);
        main.bartender.addToOrder(8, item5);
        main.bartender.createOrder(2);
        main.bartender.addToOrder(2, item6);
        assertEquals(10.25, main.bartender.pay(8));
        //check that stock is lowered somehow?
        Table bar= main.allTables.get(main.findTable(main.bartender.getBar()));
        assertEquals(3, bar.orders.size());
        assertEquals(-1, bar.findOrder(8));
    }
}
