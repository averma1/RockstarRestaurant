package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertNull(bigTable);

    }

    @Test
    public void removeTablesTest(){
        hostApi.createTable(0,5);
        hostApi.removeTable(0);
    }

    @Test
    public void clearTableTest(){
        hostApi.createTable(0,5);
        hostApi.clearTable(0);
        //assertTrue(table.isTableEmpty());
    }

    @Test
    public void seatCustomersTest(){
        Table table= new Table(0,4);
        hostApi.seatCustomers(0, 3);
        assertTrue(table.getNumOfSeats()==4);
        assertFalse(table.getNumOfSeats()==0);
    }

    @Test
    public void printTableDataTest(){
        //anika
        Table table1 = new Table(0,4);
        assertEquals( "Table number: 0, Number of Seats: 4, Available: true", hostApi.printTableData(0));

    }

    @Test
    public void viewAllTablesTest(){
        //anika
        Table table1 = new Table(0,4);
        Table table2 = new Table(1, 3);
        Table table3 = new Table(2, 6);

        hostApi.viewAllTables();

        List<Table> tableList = new ArrayList<>();
        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);



    }

    @Test
    public void searchTableBySizeTest(){
        Table table1= new Table(1,4);
        Table table2= new Table(2,6);
        Table table3= new Table(3,2);
        Restaurant restaurant=new Restaurant("test");
        List tableSizeTestList;
        tableSizeTestList=hostApi.searchTableBySize(1);
        assertEquals(1,tableSizeTestList.size());

    }
}
