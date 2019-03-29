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
        waiterApiTester.takeOrder("Chicken Parm",1,1);
        waiterApiTester.takeOrder("Spinach Ravioli",1,2);
        waiterApiTester.takeOrder("Vegan Lasagna",1,3);
        assertEquals(waiterApi.viewOrder(1,1)=="Chicken Parm");
        assertNotEquals(waiterApiTest.viewOrder(1,2)!="Chicken Parm");
    }

    @Test
    public void payTotalBillTest(){
        hostApi.createTable(0,3);
        hostApi.seatCustomers(0,3);
        int testPrice =waiterApi.payTotalBill(0);
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
