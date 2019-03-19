package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableTest {
    //hello from tabletest and the table branch!

    @Test
    public void getTableNumberTest(){

        Table table1 = new Table(8, 4);
        assertTrue(table1.getNumOfSeats() == 4);
        assertFalse(table1.getNumOfSeats() != 4);

        Table table2 = new Table(8, 0);
        assertFalse(table2.getNumOfSeats() == 0);
        //should add exception if a table with 0 seats is created

        //also should have a maximum capacity for the number of tables to have
    }

    @Test
    public void setTableNumberTest(){

        Table table1 = new Table(8, 6);
        table1.setNumOfSeats(2);
        assertTrue(table1.getNumOfSeats() == 2);
        assertFalse(table1.getNumOfSeats() != 2);

        Table table2 = new Table(8, 3);
        table2.setNumOfSeats(0);

        //should add exception if a table with 0 seats is created

    }

}