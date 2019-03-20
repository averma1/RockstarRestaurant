package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class hostApiTest {
    @Test
    public void pushTablesTest(){
        Table table1= new Table(5,5);
        Table table2= new Table(6,5);
        Table table3;
        table3=hostApi.pushTables(table1,table1);
        assertEquals(table3.getNumOfSeats(),(table1.getNumOfSeats()+table2.getNumOfSeats()));
        assertNotEquals(0,table3.getNumOfSeats());
        assertNotEquals(-1,table3.getNumOfSeats());
        assertNotEquals(1,table3.getNumOfSeats());

    }
    @Test
    public void splitTableTest(){
        int tableNumber1=1, tableNumber2=4;
        Table table= new Table(0,4);
        table=hostApi.splitTable(table);
        assertNotEquals(table.getTableNumber(),tableNumber1);

    }

    @Test
    public void removeTableTest(){

    }

    @Test
    public void clearTableTest(){
        Table table= new Table(0,4);
        hostApi.clearTable(table);
        assertTrue(table.isEmpty);
    }

    @Test
    public void seatCustomersTest(){
        Table table= new Table(0,4);
        hostApi.seatCustomers(table, 3);
        assertTrue(table.getNumOfSeats()==1);
        assertFalse(table.getNumOfSeats()==0);
    }

    @Test
    public void viewAllTablesTest(){

    }

    @Test
    public void printTableDataTest(){

    }

    @Test
    public void searchTableBySizeTest(){

    }
}
