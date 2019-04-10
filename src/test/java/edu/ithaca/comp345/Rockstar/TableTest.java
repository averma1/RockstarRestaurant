package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    @Test
    public void getTableNumOfSeatsTest(){

        Table table1 = new Table(8, 4);
        assertTrue(table1.getNumOfSeats() == 4);
        assertFalse(table1.getNumOfSeats() != 4);

        Table table2 = new Table(8, 0);
        assertTrue(table2.getNumOfSeats() == 0);
        assertFalse(table2.getNumOfSeats() != 0);
    }

    @Test
    public void setTableNumOfSeatsTest(){

        Table table1 = new Table(8, 6);
        table1.setNumOfSeats(2);
        assertTrue(table1.getNumOfSeats() == 2);
        assertFalse(table1.getNumOfSeats() != 2);

        Table table2 = new Table(4, 3);
        table2.setNumOfSeats(0);
        assertTrue(table2.getNumOfSeats() == 0, "NOTE: table cannot have 0 seats!");

        Table table3 = new Table(3, 0);
        table3.setNumOfSeats(4);
        assertTrue(table3.getNumOfSeats() == 4);
        assertFalse(table3.getNumOfSeats() != 4);


    }

    @Test
    public void getTableNumberTest(){

        Table table1 = new Table(1, 2);
        assertTrue(table1.getTableNumber() == 1);
        assertFalse(table1.getTableNumber() != 1);

        Table table2 = new Table(5, 0);
        assertTrue(table2.getTableNumber() == 5);
        assertFalse(table2.getTableNumber() != 5);

        Table table3 = new Table(2, 8);
        assertTrue(table3.getTableNumber() == 2);
        assertFalse(table3.getTableNumber() != 2);

    }

    @Test
    public void setTableNumberTest(){

        Table table1 = new Table(0, 6);
        table1.setTableNumber(1);
        assertTrue(table1.getTableNumber() == 1);
        assertFalse(table1.getTableNumber() != 1);

        Table table2 = new Table(0, 6);
        table2.setTableNumber(30);
        assertTrue(table2.getTableNumber() == 30);
        assertFalse(table2.getTableNumber() != 30);

        Table table3 = new Table(0, 6);
        table3.setTableNumber(10);
        assertTrue(table3.getTableNumber() == 10);
        assertFalse(table3.getTableNumber() != 10);

    }

    //should add exception if a table with 0 seats is created
    //also should have a maximum capacity for the number of tables to have
    //two tables can't have the same number

    @Test
    public void createOrderTest(){
        Table test1= new Table(1, 10);
        test1.createOrder(1);
        assertEquals(1, test1.orders.get(0).getNumber());
    }

    @Test
    public void addtoOrderTest(){
        Table test1= new Table(1, 10);
        test1.createOrder(1);
        MenuItem pasta= new MenuItem("pasta",10.25);
        test1.addtoOrder(pasta,1);
        List<MenuItem> returned= test1.orders.get(0).getItems();
        assertEquals("pasta", returned.get(0).getItemName());
        assertEquals(10.25, returned.get(0).getPrice());

        test1.createOrder(2);
        MenuItem steak= new MenuItem("steak", 110.25);
        test1.addtoOrder(steak,2);
        returned= test1.orders.get(1).getItems();
        assertEquals("steak", returned.get(0).getItemName());
        assertEquals(110.25, returned.get(0).getPrice());

        test1.createOrder(3);
        MenuItem beer= new MenuItem("beer", 5.25);
        test1.addtoOrder(beer,3);
        returned= test1.orders.get(2).getItems();
        assertEquals("beer", returned.get(0).getItemName());
        assertEquals(5.25, returned.get(0).getPrice());
    }


    @Test
    public void removeOrderTest(){
        //adding to order first
        Table test1 = new Table(1, 5);
        test1.createOrder(2);
        MenuItem rice = new MenuItem("rice", 2.25);
        test1.addtoOrder(rice, 2);
        List<MenuItem> items = test1.orders.get(0).getItems();
        assertEquals("rice", items.get(0).getItemName());
        assertEquals(2.25, items.get(0).getPrice());

        test1.createOrder(3);
        MenuItem chicken = new MenuItem("chicken", 5.50 );
        items.add(1, chicken);
        assertEquals("chicken", items.get(1).getItemName());
        assertEquals(5.50, items.get(1).getPrice());

        //removing order of chicken
        test1.removeOrder(3);
        assertEquals(-1 , test1.findOrder(3));

        test1.removeOrder(2);
        assertEquals(-1 , test1.findOrder(3));


    }

    @Test
    public void getItemsTest(){
        Table test1= new Table(1, 10);
        test1.createOrder(1);

        List<MenuItem> actual= new ArrayList<>();
        MenuItem pasta= new MenuItem("pasta",10.25);
        test1.addtoOrder(pasta,1);
        actual.add(pasta);
        MenuItem steak= new MenuItem("steak", 110.25);
        test1.addtoOrder(steak,1);
        actual.add(steak);
        MenuItem beer= new MenuItem("beer", 5.25);
        test1.addtoOrder(beer,1);
        actual.add(beer);

        List<MenuItem> returned= test1.orders.get(0).getItems();
        for(int i=0; i<returned.size(); i++) {
            assertEquals(actual.get(i).getItemName(), returned.get(i).getItemName());
            assertEquals(actual.get(i).getPrice(), returned.get(i).getPrice());
        }
    }

    @Test
    public void getOrderPriceTest(){
        Table test1= new Table(1, 10);
        test1.createOrder(1);

        MenuItem pasta= new MenuItem("pasta",10.25);
        test1.addtoOrder(pasta,1);
        MenuItem steak= new MenuItem("steak", 110.25);
        test1.addtoOrder(steak,1);
        MenuItem beer= new MenuItem("beer", 5.25);
        test1.addtoOrder(beer,1);

        assertEquals(125.75, test1.getOrderPrice(1));
    }

    @Test
    public void getOrdersTotalPriceTest() {
        Table test1 = new Table(1, 10);
        test1.createOrder(1);
        MenuItem pasta = new MenuItem("pasta", 10.25);
        test1.addtoOrder(pasta, 1);


        test1.createOrder(2);
        MenuItem steak = new MenuItem("steak", 110.25);
        test1.addtoOrder(steak, 2);

        test1.createOrder(3);
        MenuItem beer = new MenuItem("beer", 5.25);
        test1.addtoOrder(beer, 3);

        assertEquals(125.75, test1.getOrdersTotalPrice());
    }




}