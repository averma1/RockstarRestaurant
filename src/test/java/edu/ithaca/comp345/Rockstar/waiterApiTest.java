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
        Menuitem chickenParm= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(chickenParm,1,1);
        Menuitem spinachRavioli= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        Menuitem veganLasagna= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(veganLasagna,1,3);
        List<MenuItem> returned= waiterApi.viewOrder(1,1);
        assertEquals(waiterApi.viewOrder(returned.get(0).name==chickenParm.name));
        assertNotEquals(waiterApi.viewOrder(returned.get(1).name!=chickenParm.name));
    }

    @Test
    public void payTotalBillTest(){
        hostApi.createTable(0,3);
        hostApi.seatCustomers(1,3);
        double testPrice =waiterApi.payTotalBill(0);
        assertEquals(testPrice,waiterApi.getPrice());
        assertNotEquals(testPrice,-1);

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
        Menuitem chickenParm= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(chickenParm,1,1);
        Menuitem cake= new MenuItem(desert, 7.35);
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        Menuitem veganLasagna= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(veganLasagna,1,3);
        List itemSplitBill= waiterApi.splitBillByItem(1);
        assertEquals(itemSplitBill.get(0)==10.25);
        assertNotEquals(itemSplitBill.get(0)==7.35);
        assertNotEquals(itemSplitBill.get(0)==-1);
        assertNotEquals(itemSplitBill.get(0)==27.85);
        assertEquals(itemSplitBill.get(1)==7.35);
    }

    @Test
    public void viewOrderTest(){
        hostApi.createTable(1,3);
        hostApi.seatCustomers(1,3);
        Menuitem chickenParm= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(chickenParm,1,1);
        Menuitem spinachRavioli= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        Menuitem veganLasagna= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(veganLasagna,1,3);
        waiterApi.viewOrder(1,1);
        assertEquals(waiterApi.viewOrder(1,1),chickenParm.name);
        assertNotEquals(waiterApi.viewOrder(1,1),veganLasagna.name);
    }
}
