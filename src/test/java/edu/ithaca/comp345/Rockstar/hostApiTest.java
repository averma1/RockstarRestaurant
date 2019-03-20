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
        table=hostApi.splitTable(table, tableNumber1,tableNumber2);
        assertNotEquals(table.getTableNumber(),tableNumber1);

    }

    @Test
    public void removeTables(){}

    @Test
    public void clearTableTest(){
        Table table= new Table(0,4);
        assertTrue(clearTable(table));
        assertFalse(clearTable(table));
    }

    @Test
    public void seatCustomersTest(){
        Table table= new Table(0,4);
        assertTrue(seatCustomers(table));
        assertFalse(seatCustomers(table));
    }

    @Test
    public void viewTableTest(){

    }

    @Test
    public void searchTableBySize(){}
}
