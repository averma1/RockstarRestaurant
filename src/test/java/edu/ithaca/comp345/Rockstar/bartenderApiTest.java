package edu.ithaca.comp345.Rockstar;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class bartenderApiTest {

    @Test
    public void createOrderTest(){}

    @Test
    public void addToOrderTest(){
        Order orderTester= new Order(0);
        MenuItem ChickenParmSoda = new MenuItem(null, 4.25, "Chicken Parm Soda");
        MenuItem BulmersCider = new MenuItem(null,9.50,"Bulmers Hard Cider");
        bartenderApi bartenderApiTester= new bartenderApi();
        bartenderApiTester.addToOrder(0,ChickenParmSoda);
        assertTrue(orderTester.items.size()==1);
        bartenderApiTester.addToOrder(0,BulmersCider);
        assertTrue(orderTester.items.size()==2);
        assertNotEquals(orderTester.items.size(),1);
        assertNotEquals(orderTester.items.size(),0);
        assertEquals(orderTester.items.get(0).getItemName(),"Chicken Parm Soda");
        assertEquals(orderTester.items.get(1).getPrice(),9.50);
        assertNotEquals(orderTester.items.get(0).getItemName(),"Bulmers Hard Cider");
    }

    @Test
    public void payTest(){
        Order orderTester= new Order(0);
        MenuItem ChickenParmSoda = new MenuItem(null, 4.25, "Chicken Parm Soda");
        MenuItem BulmersCider = new MenuItem(null,9.50,"Bulmers Hard Cider");
        bartenderApi bartenderApiTester= new bartenderApi();
        bartenderApiTester.addToOrder(0,ChickenParmSoda);
        assertTrue(orderTester.items.size()==1);
        bartenderApiTester.addToOrder(0,BulmersCider);
        bartenderApiTester.pay(0);
        assertTrue(orderTester.getTotalPrice()==0.00);
        assertNotEquals(orderTester.getTotalPrice(),13.75);

    }

    @Test
    public void giveBarTest(){}
}
