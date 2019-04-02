package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class waiterApiTest {
    @Test
    public void takeOrderTest(){
        Restaurant main= new Restaurant("Test");
        main.createTable(1,5);

        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        main.waiter.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 10.25, "spinach ravioli");
        main.waiter.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 10.25, "vegan lasagna");
        main.waiter.takeOrder(veganLasagna,1,3);

    }

    @Test
    public void payTotalBillTest(){
        Restaurant main= new Restaurant("Test");
        waiterApi waiterApiTester= main.waiter;
        main.createTable(1,3);

        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        waiterApiTester.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 10.25, "spinach ravioli");
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 10.25, "vegan lasagna");
        waiterApiTester.takeOrder(veganLasagna,1,3);

        double testCost= waiterApiTester.payTotalBill(1);

        assertEquals(30.75,testCost);
        assertFalse(testCost==10.25);
        assertFalse(testCost==20.50);


    }

    @Test
    public void splitBillByTotalTest(){
        Restaurant main= new Restaurant("Test");
        waiterApi waiterApiTester= main.waiter;
        main.createTable(1,3);

        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        waiterApiTester.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 10.25, "spinach ravioli");
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 9.50, "vegan lasagna");
        waiterApiTester.takeOrder(veganLasagna,1,3);

        double price=waiterApiTester.splitBillByTotal(1,3);
        assertNotEquals(9, price);
        assertEquals(10.0, price);

        MenuItem Lasagna= new MenuItem(null, 9.50, "vegan lasagna");
        waiterApiTester.takeOrder(Lasagna,1,3);
        price=waiterApiTester.splitBillByTotal(1,3);
        assertEquals(13.17, price);
    }


    @Test
    public void splitBillByItemTest(){
        Restaurant main= new Restaurant("Test");
        waiterApi waiterApiTester= main.waiter;
        main.createTable(1,3);

        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        waiterApiTester.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 7.35, "spinach ravioli");
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 12.25, "vegan lasagna");
        waiterApiTester.takeOrder(veganLasagna,1,3);

        List<Order> itemSplitBill= waiterApiTester.splitBillByItem(1);

        assertEquals(itemSplitBill.get(0).getTotalPrice(),10.25);
        assertNotEquals(itemSplitBill.get(0).getTotalPrice(),7.35);
        assertNotEquals(itemSplitBill.get(0).getTotalPrice(),-1);
        assertNotEquals(itemSplitBill.get(0).getTotalPrice(),27.85);
        assertEquals(itemSplitBill.get(1).getTotalPrice(),7.35);

        assertEquals(10.25, itemSplitBill.get(0).getTotalPrice());
        assertNotEquals(7.35, itemSplitBill.get(0).getTotalPrice());
        assertNotEquals(-1, itemSplitBill.get(0).getTotalPrice());
        assertNotEquals(27.85, itemSplitBill.get(0).getTotalPrice());
        assertEquals(7.35, itemSplitBill.get(1).getTotalPrice());
        assertEquals(12.25, itemSplitBill.get(2).getTotalPrice());

    }

    @Test
    public void viewOrderTest(){
        Restaurant main= new Restaurant("Test");
        waiterApi testing= main.waiter;
        main.createTable(1,5);

        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        testing.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 10.25, "spinach ravioli");
        testing.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 10.25, "vegan lasagna");
        testing.takeOrder(veganLasagna,1,3);

        List<MenuItem> viewStatus= testing.viewOrder(1,1);
        List<MenuItem> viewStatus2= testing.viewOrder(1,2);
        assertEquals(chickenParm.getItemName(), viewStatus.get(0).getItemName());
        assertNotEquals(veganLasagna.getItemName(), viewStatus2.get(0).getItemName());
    }
}
