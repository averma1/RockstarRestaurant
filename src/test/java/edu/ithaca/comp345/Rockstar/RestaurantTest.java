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
}
