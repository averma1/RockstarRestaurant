package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantIT {

    @Test
    public void waiterPlaceOrderTest(){
        //should read a file and create a menu, stock, and tables
        Restaurant main= new Restaurant("test");
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

    }

    @Test
    public void bartenderPlaceOrderTest(){
        //should read a file and create a menu, stock, create bar, and tables
        Restaurant main= new Restaurant("test");

    }
}
