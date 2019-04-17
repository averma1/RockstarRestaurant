package edu.ithaca.comp345.Rockstar;

//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertTrue;
//import static org.testng.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {

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
        testRest.loadTablesFromFile("tableTestFile1.txt");
        System.out.println(testRest.allTables.size());
        //assertTrue();

    }
}
