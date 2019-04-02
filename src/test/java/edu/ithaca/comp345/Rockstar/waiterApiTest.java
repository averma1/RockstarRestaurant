package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class waiterApiTest {
    @Test
    public void takeOrderTest(){
        waiterApi waiterApiTester= new waiterApi();
        hostApi.createTable(0,3);
        hostApi.seatCustomers(1,3);
        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        waiterApiTester.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 10.25, "spinach ravioli");
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 10.25, "vegan lasagna");
        waiterApiTester.takeOrder(veganLasagna,1,3);

    }

    @Test
    public void payTotalBillTest(){
        waiterApi waiterApiTester= new waiterApi();
        hostApi.createTable(0,3);
        hostApi.seatCustomers(1,3);
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
        hostApi.createTable(0,3);
        hostApi.seatCustomers(0,3);
        int testPrice=9;
        int testSplitPrice=3;
        double price=waiterApi.splitBillByTotal(0,3);
        assertNotEquals(price,testPrice);
        assertEquals(testSplitPrice,price);
    }


    @Test
    public void splitBillByItemTest(){
        hostApi.createTable(1,3);
        hostApi.seatCustomers(1,3);
        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        waiterApi.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 10.25, "spinach ravioli");
        waiterApi.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 10.25, "vegan lasagna");
        waiterApi.takeOrder(veganLasagna,1,3);
        List<Order> itemSplitBill= waiterApi.splitBillByItem(1);
        assertEquals(itemSplitBill.get(0).getTotalPrice(),10.25);
        assertNotEquals(itemSplitBill.get(0).getTotalPrice(),7.35);
        assertNotEquals(itemSplitBill.get(0).getTotalPrice(),-1);
        assertNotEquals(itemSplitBill.get(0).getTotalPrice(),27.85);
        assertEquals(itemSplitBill.get(1).getTotalPrice(),7.35);
    }

    @Test
    public void viewOrderTest(){
        hostApi.createTable(1,3);
        hostApi.seatCustomers(1,3);
        MenuItem chickenParm= new MenuItem(null, 10.25, "chicken parm");
        waiterApi.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem(null, 10.25, "spinach ravioli");
        waiterApi.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem(null, 10.25, "vegan lasagna");
        waiterApi.takeOrder(veganLasagna,1,3);
        List<MenuItem> viewStatus= waiterApi.viewOrder(1,1);
        assertEquals(viewStatus.get(0).getItemName(),chickenParm.getItemName());
        assertNotEquals(viewStatus.get(2).getItemName(),veganLasagna.getItemName());
    }
}
