package edu.ithaca.comp345.Rockstar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class bartenderApiTest {

    /*
    @Test
    public void addToOrderTest(){
        Order orderTester= new Order(0);
        MenuItem ChickenParmSoda = new MenuItem("Chicken Parm Soda", 4.25);
        MenuItem BulmersCider = new MenuItem("Bulmers Hard Cider", 9.50);

        Restaurant main= new Restaurant("test");
        main.createBar(50);
        bartenderApi bartenderApiTester= main.bartender;

        bartenderApiTester.addToOrder(0,ChickenParmSoda);
        assertTrue(main.waiter.viewOrder(420, 0).size()==1);
        bartenderApiTester.addToOrder(0,BulmersCider);
        assertTrue(main.waiter.viewOrder(420, 0).size()==2);
        assertNotEquals(main.waiter.viewOrder(420, 0).size(),1);
        assertNotEquals(main.waiter.viewOrder(420, 0),0);

        assertEquals(main.waiter.viewOrder(420, 0).get(0).getItemName(),"Chicken Parm Soda");
        assertEquals(main.waiter.viewOrder(420, 0).get(1).getPrice(),9.50);
        assertNotEquals(main.waiter.viewOrder(420, 0).get(0).getItemName(),"Bulmers Hard Cider");
    }

    @Test
    public void payTest(){
        Order orderTester= new Order(0);
        MenuItem ChickenParmSoda = new MenuItem("Chicken Parm Soda", 4.25 );
        MenuItem BulmersCider = new MenuItem("Bulmers Hard Cider",9.50);

        Restaurant main= new Restaurant("test");
        main.createBar(50);
        bartenderApi bartenderApiTester= main.bartender;

        bartenderApiTester.addToOrder(0,ChickenParmSoda);
        assertTrue(main.waiter.viewOrder(420, 0).size()==1);
        bartenderApiTester.addToOrder(0,BulmersCider);
        bartenderApiTester.pay(0);
        assertTrue(orderTester.getTotalPrice()==0.00);
        assertNotEquals(orderTester.getTotalPrice(),13.75);

    }
    */
}
