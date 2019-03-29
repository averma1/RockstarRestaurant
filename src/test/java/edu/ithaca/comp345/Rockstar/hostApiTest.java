package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class hostApiTest {
    @Test
    public void pushTablesTest(){
        Table table3;
        hostApi.createTable(5,5);
        hostApi.createTable(6,5);
        table3=hostApi.pushTables(5,6);
        assertEquals(table3.getNumOfSeats(),10);
        assertNotEquals(0,table3.getNumOfSeats());
        assertNotEquals(-1,table3.getNumOfSeats());
        assertNotEquals(1,table3.getNumOfSeats());

    }

    @Test
    public void splitTableTest(){
        int tableNumber1=1, tableNumber2=4;
        hostApi.createTable(tableNumber1,4);
        hostApi.createTable(tableNumber2,5);
        Table bigTable= hostApi.pushTables(tableNumber1,tableNumber2);
        hostApi.printTableData(bigTable.getTableNumber());
        hostApi.splitTable(bigTable.getTableNumber());
        hostApi.printTableData(tableNumber1);
        hostApi.printTableData(tableNumber2);
        assertEquals(-1,hostApi.findInMulti(3));
    }

    @Test
    public void removeTablesTest(){
        hostApi.createTable(0,5);
        hostApi.removeTable(0);
        assertEquals(-1,hostApi.findTable(0));
    }

    @Test
    public void clearTableTest(){
        hostApi.createTable(0,5);
        hostApi.clearTable(0);
        assertTrue(hostApi.allTables.get(0).isTableEmpty());
    }

    @Test
    public void seatCustomersTest(){
        Table table= new Table(0,4);
        hostApi.seatCustomers(0, 3);
        assertEquals(4,table.getNumOfSeats());
        assertFalse(table.getNumOfSeats()==0);
    }

    @Test
    public void viewAllTablesTest(){
        Table table1 = new Table(0,4);
        Table table2 = new Table(1, 3);
        Table table3 = new Table(2, 6);
        int myTables = hostApi.viewAllTables();
        assertEquals(3, myTables);

    }

    @Test
    public void searchTableBySizeTest(){
        int tableSizeTester=4;
        Table table1= new Table(1,4);
        Table table2= new Table(2,6);
        Table table3= new Table(3,2);
        Restaurant restaurant=new Restaurant("test");
        List tableSizeTestList;
        tableSizeTestList=hostApi.searchTableBySize(4);
        assertEquals(1,tableSizeTestList.size());

    }

    @Test
    public void addToWaitlistTest(){
        hostApi testing= new hostApi();
        testing.addToWaitlist("Susan", 5);
        assertEquals(0, hostApi.findParty("Susan"));

        testing.addToWaitlist("John", 0);
        assertEquals(1, hostApi.findParty("John"));

        testing.addToWaitlist("Bill", 15);
        assertEquals(2, hostApi.findParty("Bill"));
    }

    @Test
    public void viewWaitlistTest(){
        hostApi testing= new hostApi();
        List<Party> actual= new LinkedList<>();
        Party test1= new Party("Susan", 5);
        ((LinkedList<Party>) actual).add(test1);
        testing.addToWaitlist("Susan", 5);
        Party test2= new Party("John", 5);
        ((LinkedList<Party>) actual).add(test2);
        testing.addToWaitlist("John", 5);
        Party test3= new Party("Bill", 5);
        ((LinkedList<Party>) actual).add(test3);
        testing.addToWaitlist("Bill", 5);

        List<Party> returned= testing.viewWaitlist();

        for(int i=0; i<actual.size(); i++){
            assertEquals(actual.get(i).name, returned.get(i).name);
            assertEquals(actual.get(i).number, returned.get(i).number);
        }
    }

    @Test
    public void removeFromWaitlistTest(){
        hostApi testing= new hostApi();
        List<Party> actual= new LinkedList<>();
        testing.addToWaitlist("Susan", 5);
        Party test2= new Party("John", 5);
        ((LinkedList<Party>) actual).add(test2);
        testing.addToWaitlist("John", 5);
        Party test3= new Party("Bill", 5);
        ((LinkedList<Party>) actual).add(test3);
        testing.addToWaitlist("Bill", 5);

        testing.removeFromWaitlist("Susan");

        List<Party> returned= testing.viewWaitlist();

        for(int i=0; i<actual.size(); i++){
            assertEquals(actual.get(i).name, returned.get(i).name);
            assertEquals(actual.get(i).number, returned.get(i).number);
        }
    }
}
