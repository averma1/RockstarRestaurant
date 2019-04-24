package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class waiterApiTest {
    @Test
    public void takeOrderTest(){
        Restaurant main= new Restaurant("Test");
        main.createTable(1,5);

        MenuItem chickenParm= new MenuItem("chicken parm", 10.25);
        main.waiter.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem("spinach ravioli", 10.25);
        main.waiter.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem("vegan lasagna", 10.25);
        main.waiter.takeOrder(veganLasagna,1,3);

    }

    @Test
    public void payTotalBillTest(){
        Restaurant main= new Restaurant("Test");
        waiterApi waiterApiTester= main.waiter;
        main.createTable(1,3);

        MenuItem chickenParm= new MenuItem("chicken parm", 10.25);
        waiterApiTester.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem("spinach ravioli", 10.25);
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem("vegan lasagna", 10.25);
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

        MenuItem chickenParm= new MenuItem("chicken parm", 10.25);
        waiterApiTester.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem("spinach ravioli", 10.25);
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem("vegan lasagna", 9.50);
        waiterApiTester.takeOrder(veganLasagna,1,3);

        double price=waiterApiTester.splitBillByTotal(1,3);
        assertNotEquals(9, price);
        assertEquals(10.0, price);

        MenuItem Lasagna= new MenuItem("vegan lasagna", 9.50);
        waiterApiTester.takeOrder(Lasagna,1,3);
        price=waiterApiTester.splitBillByTotal(1,3);
        assertEquals(13.17, price);
    }


    @Test
    public void splitBillByItemTest(){
        Restaurant main= new Restaurant("Test");
        waiterApi waiterApiTester= main.waiter;
        main.createTable(1,3);

        MenuItem chickenParm= new MenuItem("chicken parm", 10.25);
        waiterApiTester.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem("spinach ravioli", 7.35);
        waiterApiTester.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem("vegan lasagna", 12.25);
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

        MenuItem chickenParm = new MenuItem("chicken parm", 10.25);
        testing.takeOrder(chickenParm,1,1);
        MenuItem spinachRavioli= new MenuItem("spinach ravioli", 10.25);
        testing.takeOrder(spinachRavioli,1,2);
        MenuItem veganLasagna= new MenuItem("vegan lasagna", 10.25);
        testing.takeOrder(veganLasagna,1,3);

        List<MenuItem> viewStatus= testing.viewOrder(1,1);
        List<MenuItem> viewStatus2= testing.viewOrder(1,2);
        assertEquals(chickenParm.getItemName(), viewStatus.get(0).getItemName());
        assertNotEquals(veganLasagna.getItemName(), viewStatus2.get(0).getItemName());
    }

    @Test
    public void getWaitersTablesTest(){
        Restaurant main= new Restaurant("test");
        managerApi manager= main.manager;

        manager.addEmployee(1234, "Kaylee", "waiter");
        manager.addEmployee(3234, "John", "waiter");
        manager.addEmployee(2345, "Julia", "host");

        main.createTable(1, 10);
        main.createTable(2, 10);
        main.createTable(3, 10);
        main.createTable(4, 10);
        main.createTable(5, 10);

        manager.addTableToWaiter(1, 1234, "Kaylee");
        manager.addTableToWaiter(2, 1234, "Kaylee");
        manager.addTableToWaiter(3, 3234, "John");
        manager.addTableToWaiter(4, 3234, "John");

        List<Table> table1= new ArrayList<>();
        table1.add(main.allTables.get(main.findTable(1)));
        table1.add(main.allTables.get(main.findTable(2)));
        List<Table> table2= new ArrayList<>();
        table2.add(main.allTables.get(main.findTable(3)));
        table2.add(main.allTables.get(main.findTable(4)));

        assertEquals(table1, main.waiter.getWaitersTables(1234, "Kaylee"));
        assertEquals(table2, main.waiter.getWaitersTables(3234, "John"));

        assertThrows(IndexOutOfBoundsException.class, ()->{main.waiter.getWaitersTables(2345, "Julia");});
        assertThrows(IndexOutOfBoundsException.class, ()->{main.waiter.getWaitersTables(9999, "Julia");});
        assertThrows(IndexOutOfBoundsException.class, ()->{main.waiter.getWaitersTables(1234, "Kay");});

    }
}
