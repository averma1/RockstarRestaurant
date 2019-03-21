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
    public void removeTables(){
        Table table= new Table(0,4);
        table=hostApi.removeTable(table);
        assertNull(table);

    }

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
        Table table = new Table(0,4);
        //Deleted original implementation
        //Methodolgy TBD tomorrow.
    }

    @Test
    public void searchTableBySize(){ //TODO Finish this after discussion with team
        Table table1= new Table(1,4);
        Table table2= new Table(2,6);
        Table table3= new Table(3,2);
        Restaurant restaurant=new Restaurant("test");
        //Stuck on how to exactly implement getting the list of tables to then search said tables by size.
    }
}
