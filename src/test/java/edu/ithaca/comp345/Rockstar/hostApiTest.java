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
        hostApi testin= new hostApi();
        Table table3;
        testin.createTable(5,5);
        testin.createTable(6,5);
        table3=hostApi.pushTables(5,6);

        assertEquals(table3.getNumOfSeats(),10);
        assertNotEquals(0,table3.getNumOfSeats());
        assertNotEquals(-1,table3.getNumOfSeats());
        assertNotEquals(1,table3.getNumOfSeats());

        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.pushTables(2,5); });
        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.pushTables(5,2); });
        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.pushTables(2,8); });
    }

    @Test
    public void splitTableTest(){
        hostApi testin= new hostApi();
        testin.createTable(1,4);
        testin.createTable(4,5);
        Table bigTable= testin.pushTables(1,4);

        testin.printTableData(bigTable.getTableNumber());
        testin.splitTable(bigTable.getTableNumber());
        testin.printTableData(1);
        testin.printTableData(4);
        assertEquals(-1,testin.findInMulti(3));

        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.splitTable(10); });
        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.splitTable(1); });
    }

    @Test
    public void removeTablesTest(){
        hostApi testin= new hostApi();
        testin.createTable(0,5);
        testin.removeTable(0);
        assertEquals(-1,testin.findTable(0));

        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.removeTable(7); });
    }

    @Test
    public void clearTableTest(){
        hostApi testin= new hostApi();
        testin.createTable(0,5);
        testin.clearTable(0);
        assertTrue(testin.allTables.get(0).isTableEmpty());
        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.clearTable(7); });
    }

    @Test
    public void seatCustomersTest(){
        hostApi testin= new hostApi();
        testin.createTable(0,4);
        testin.createTable(1,5);
        testin.seatCustomers(0, 3);
        assertEquals(4,testin.allTables.get(0).getNumOfSeats());
        assertFalse(testin.allTables.get(0).getNumOfSeats()==0);

        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.seatCustomers(7,5); });
        assertThrows(IndexOutOfBoundsException.class, ()->{ testin.seatCustomers(1,10); });
    }

    @Test
    public void viewAllTablesTest(){
        hostApi testin= new hostApi();
        testin.createTable(0,4);
        testin.createTable(1,3);
        testin.createTable(2,6);
        int myTables = testin.viewAllTables();
        assertEquals(3, myTables);

    }

    @Test
    public void searchTableBySizeTest(){
        hostApi testin= new hostApi();
        testin.createTable(1,4);
        testin.createTable(2,6);
        testin.createTable(3,2);

        List tableSizeTestList;
        tableSizeTestList=testin.searchTableBySize(4);
        assertEquals(1,tableSizeTestList.size());

    }

    @Test
    public void addToWaitlistTest(){
        hostApi testing= new hostApi();
        testing.createTable(1,100);
        testing.addToWaitlist("Susan", 5);
        assertEquals(0, hostApi.findParty("Susan"));

        testing.addToWaitlist("John", 2);
        assertEquals(1, hostApi.findParty("John"));

        testing.addToWaitlist("Bill", 15);
        assertEquals(2, hostApi.findParty("Bill"));

        assertThrows(IndexOutOfBoundsException.class, ()->{ testing.addToWaitlist("Bill", 10); });
        assertThrows(IndexOutOfBoundsException.class, ()->{ testing.addToWaitlist("Chase", 0); });
        assertThrows(IndexOutOfBoundsException.class, ()->{ testing.addToWaitlist("Cher", -10); });
        assertThrows(IndexOutOfBoundsException.class, ()->{ testing.addToWaitlist("Kyle", 1000); });
    }

    @Test
    public void viewWaitlistTest(){
        hostApi testing= new hostApi();
        testing.createTable(1,100);
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
        testing.createTable(1,100);
        List<Party> actual= new LinkedList<>();
        testing.addToWaitlist("Susan", 5);
        Party test2= new Party("John", 5);
        ((LinkedList<Party>) actual).add(test2);
        testing.addToWaitlist("John", 5);
        Party test3= new Party("Bill", 5);
        ((LinkedList<Party>) actual).add(test3);
        testing.addToWaitlist("Bill", 5);

        Party removed= testing.removeFromWaitlist(5);
        assertEquals("Susan", removed.name);
        assertEquals(5, removed.number);

        removed= testing.removeFromWaitlist(5);
        assertEquals("John", removed.name);
        assertEquals(5, removed.number);

        removed= testing.removeFromWaitlist(5);
        assertEquals("Bill", removed.name);
        assertEquals(5, removed.number);

        removed= testing.removeFromWaitlist(5);
        assertEquals(null, removed);

    }
}
