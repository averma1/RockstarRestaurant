package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class waiterApiTest {
    @Test
    public void takeOrderTest(){
        waiterApi waiterApiTester= new waiterApi();
        List menuOrderList= new LinkedList();
        hostApi.createTable(0,3);
        hostApi.seatCustomers(0,3);
        Menuitem chickenParm= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(chickenParm,1,1);
        Menuitem spinachRavioli= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        Menuitem veganLasagna= new MenuItem(pasta, 10.25);
        waiterApiTester.takeOrder(veganLasagna,1,3);

        List<MenuItem> returned= waiterApi.viewOrder(1,1);
        assertEquals(waiterApi.viewOrder(returned.get(0).name==chickenParm.name);
        assertNotEquals(waiterApi.viewOrder(returned.get(1).name!=chickenParm.name;
    }

    @Test
    public void payTotalBillTest(){
        hostApi.createTable(0,3);
        hostApi.seatCustomers(0,3);
        double testPrice =waiterApi.payTotalBill(0);
        assertEquals(testPrice,waiterApi.getPrice());
        assertNotEquals(testPrice,-1);

    }

    @Test
    public void splitBillByTotalTest(){}

    @Test
    public void splitBillByItemTest(){}

    @Test
    public void viewOrderTest(){}
}
