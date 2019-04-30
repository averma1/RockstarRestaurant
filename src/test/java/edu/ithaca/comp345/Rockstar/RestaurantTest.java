package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    public Restaurant buildBaseRest(){
        Restaurant main= new Restaurant("test.txt");

        main.createTable(2, 10);

        main.stock.addIngredient("ravioli", .50, 20);
        main.stock.addIngredient("chicken", .50, 60);
        main.stock.addIngredient("breadSticks", .50, 350);

        MenuItem item1= new MenuItem("chicken parm", 10);
        item1.addIngredient(main.stock.getIngredient("chicken"), 10);
        MenuItem item2= new MenuItem("cheese ravioli", 10);
        item2.addIngredient(main.stock.getIngredient("ravioli"), 5);
        MenuItem item3= new MenuItem("bread sticks", 10);
        item3.addIngredient(main.stock.getIngredient("breadSticks"), 50);
        MenuItem item4= new MenuItem("coffee", 10);
        MenuItem item5= new MenuItem("chocolate cake", 10);
        MenuItem item6= new MenuItem("beer", 10);

        main.menu.addMenuItem(item1);
        main.menu.addMenuItem(item2);
        main.menu.addMenuItem(item3);
        main.menu.addMenuItem(item4);
        main.menu.addMenuItem(item5);
        main.menu.addMenuItem(item6);

        main.bartender.barStock.addIngredient("tequila", .50, 20);
        main.bartender.barStock.addIngredient("beer", .50, 60);
        main.bartender.barStock.addIngredient("soup", .50, 350);

        MenuItem item7= new MenuItem("margarita", 10);
        item7.addIngredient(main.bartender.barStock.getIngredient("tequila"), 5);
        MenuItem item8= new MenuItem("red wine", 10);
        MenuItem item9= new MenuItem("soup", 10);
        item9.addIngredient(main.bartender.barStock.getIngredient("soup"), 50);
        MenuItem item10= new MenuItem("coffee", 10);
        MenuItem item11= new MenuItem("mojito", 10);
        MenuItem item12= new MenuItem("beer", 10);
        item12.addIngredient(main.bartender.barStock.getIngredient("beer"), 10);

        main.bartender.barMenu.addMenuItem(item7);
        main.bartender.barMenu.addMenuItem(item8);
        main.bartender.barMenu.addMenuItem(item9);
        main.bartender.barMenu.addMenuItem(item10);
        main.bartender.barMenu.addMenuItem(item11);
        main.bartender.barMenu.addMenuItem(item12);

        main.createBar(50);

        return main;
    }


    @Test
    public void getAndSetNameTest(){
        Restaurant testRest = new Restaurant("Saigon Kitchen");
        assertTrue(testRest.getName()=="Saigon Kitchen");
        assertFalse(testRest.getName()!="Saigon Kitchen");

        testRest.setName("Luna");
        assertTrue(testRest.getName()=="Luna");
        assertFalse(testRest.getName()!="Luna");
    }


    @Test void loadTablesFromFileTests() throws Exception{
        Restaurant testRest = new Restaurant("My Restaurant");

        //the restaurant currently has no tables
        assertTrue(testRest.allTables.size() == 0);

        //load in a file
        testRest.loadTablesFromFile("tableTestFile1.txt");

        //confirm that the tables are created
        assertTrue(testRest.allTables.get(0).getTableNumber() == 1);
        assertTrue(testRest.allTables.get(0).getNumOfSeats() == 4);
        assertTrue(testRest.allTables.get(1).getTableNumber() == 2);
        assertTrue(testRest.allTables.get(1).getNumOfSeats() == 8);
        assertTrue(testRest.allTables.get(2).getTableNumber() == 3);
        assertTrue(testRest.allTables.get(2).getNumOfSeats() == 6);
        assertTrue(testRest.allTables.get(3).getTableNumber() == 4);
        assertTrue(testRest.allTables.get(3).getNumOfSeats() == 4);

        //try to load the same file again (shouldn't create any tables due to duplicate table numbers)
        assertThrows(IndexOutOfBoundsException.class, ()-> testRest.loadTablesFromFile("tableTestFile1.txt"));

    }

    @Test
    public void loadTablesToFileTest() throws Exception{

        Restaurant testRest = new Restaurant("My Restaurant");

        //load in a file
        testRest.loadTablesFromFile("tableTestFile1.txt");

        //confirm that the tables are created
        assertTrue(testRest.allTables.get(0).getTableNumber() == 1);
        assertTrue(testRest.allTables.get(0).getNumOfSeats() == 4);
        assertTrue(testRest.allTables.get(1).getTableNumber() == 2);
        assertTrue(testRest.allTables.get(1).getNumOfSeats() == 8);
        assertTrue(testRest.allTables.get(2).getTableNumber() == 3);
        assertTrue(testRest.allTables.get(2).getNumOfSeats() == 6);
        assertTrue(testRest.allTables.get(3).getTableNumber() == 4);
        assertTrue(testRest.allTables.get(3).getNumOfSeats() == 4);

        //save the tables to the file
        testRest.saveTablesToFile("tableOutputFile.txt");

        //create a new restaurant
        Restaurant newRes = new Restaurant("My new Restaurant");

        //load the outut of tables to a new Resturant
        newRes.loadTablesFromFile("tableOutputFile.txt");

        //check that this new restaurant now has the same tables
        assertTrue(newRes.allTables.get(0).getTableNumber() == 1);
        assertTrue(newRes.allTables.get(0).getNumOfSeats() == 4);
        assertTrue(newRes.allTables.get(1).getTableNumber() == 2);
        assertTrue(newRes.allTables.get(1).getNumOfSeats() == 8);
        assertTrue(newRes.allTables.get(2).getTableNumber() == 3);
        assertTrue(newRes.allTables.get(2).getNumOfSeats() == 6);
        assertTrue(newRes.allTables.get(3).getTableNumber() == 4);
        assertTrue(newRes.allTables.get(3).getNumOfSeats() == 4);

    }

    @Test
    public void waiterPlaceOrderTest(){
        //should read a file and create a menu, stock, and tables
        Restaurant main= buildBaseRest();
        main.host.seatCustomers(2, 4);
        MenuItem item1= main.menu.getMenuItem("chicken parm");
        MenuItem item2= main.menu.getMenuItem("cheese ravioli");
        MenuItem item3= main.menu.getMenuItem("bread sticks");
        MenuItem item4= main.menu.getMenuItem("coffee");
        MenuItem item5= main.menu.getMenuItem("chocolate cake");
        MenuItem item6= main.menu.getMenuItem("beer");
        main.waiter.takeOrder("chicken parm", 2, 1);
        main.waiter.takeOrder("cheese ravioli", 2, 2);
        main.waiter.takeOrder("bread sticks", 2, 3);
        main.waiter.takeOrder("coffee", 2, 4);
        main.waiter.takeOrder("chocolate cake", 2, 2);
        main.waiter.takeOrder("beer", 2, 3);
        assertEquals(15, main.stock.getQuantity("ravioli"));
        assertEquals(50, main.stock.getQuantity("chicken"));
        assertEquals(300, main.stock.getQuantity("breadSticks"));
        assertEquals(60.00, main.waiter.payTotalBill(2));
        main.saveToFile("test.txt");
    }

    @Test
    public void bartenderPlaceOrderTest(){
        //should read a file and create a menu, stock, create bar, and tables
        Restaurant main= buildBaseRest();
        MenuItem item1= main.bartender.barMenu.getMenuItem("margarita");
        MenuItem item2= main.bartender.barMenu.getMenuItem("red wine");
        MenuItem item3= main.bartender.barMenu.getMenuItem("soup");
        MenuItem item4= main.bartender.barMenu.getMenuItem("coffee");
        MenuItem item5= main.bartender.barMenu.getMenuItem("mojito");
        MenuItem item6= main.bartender.barMenu.getMenuItem("beer");
        main.bartender.addToOrder(1, "margarita");
        main.bartender.addToOrder(1, "red wine");
        main.bartender.addToOrder(4, "soup");
        main.bartender.addToOrder(4, "coffee");
        main.bartender.addToOrder(8, "mojito");
        main.bartender.addToOrder(2, "beer");
        assertEquals(15, main.bartender.barStock.getQuantity("tequila"));
        assertEquals(50, main.bartender.barStock.getQuantity("beer"));
        assertEquals(300, main.bartender.barStock.getQuantity("soup"));
        assertEquals(10.00, main.bartender.pay(8));
        Table bar= main.allTables.get(main.findTable(main.bartender.getBar()));
        assertEquals(3, bar.orders.size());
        assertEquals(-1, bar.findOrder(8));
        main.saveToFile("test.txt");
    }

    @Test
    public void PinFileIOTest(){
        Restaurant testRest = new Restaurant();

        //load in Employees and Pins from a file

        //check if they exist

        //save to file

        //load saved file into new Restaurant

        //check if they exist



    }


}
