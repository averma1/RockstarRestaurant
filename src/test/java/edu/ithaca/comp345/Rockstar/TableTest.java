package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;
import java.io.IOException;

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

}