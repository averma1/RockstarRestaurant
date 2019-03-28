package edu.ithaca.comp345.Rockstar;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    @Test
    public void getNumberTest(){
        Order test1= new Order(1);
        assertEquals(1, test1.getNumber());

        Order test2= new Order(0);
        assertEquals(0, test2.getNumber());

        Order test3= new Order(-12);
        assertEquals(-12, test3.getNumber());

        Order test4= new Order(12);
        assertEquals(12, test4.getNumber());
    }

    @Test
    public void setNumberTest(){
        Order test1= new Order(0);
        test1.setNumber(1);
        assertEquals(1, test1.getNumber());

        Order test2= new Order(12);
        test2.setNumber(0);
        assertEquals(0, test2.getNumber());

        Order test3= new Order(1);
        test3.setNumber(-12);
        assertEquals(-12, test3.getNumber());

        Order test4= new Order(-12);
        test4.setNumber(12);
        assertEquals(12, test4.getNumber());
    }

    @Test
    public void getItemsTest(){
        Order test1= new Order(5);
        Menuitem pasta= new MenuItem(pasta, 12.15);
        test1.addItem(pasta);
        Menuitem steak= new MenuItem(pasta, 121.34);
        test1.addItem(steak);
        Menuitem beer= new MenuItem(beer, 1.25);
        test1.addItem(beer);

        List<MenuItem> actual= new ArrayList<>();
        actual.add(pasta);
        actual.add(steak);
        actual.add(beer);
        List<MenuItem> returned= test1.getItems();
        for(int i=0; i<test1.items.size(); i++){
            assertEquals(actual.get(i).getName,returned.get(i).getName );
        }
    }

    @Test
    public void getTotalPriceTest(){
        Order test1= new Order(5);
        Menuitem pasta= new MenuItem(pasta, 10.25);
        test1.addItem(pasta);
        Menuitem steak= new MenuItem(pasta, 110.25);
        test1.addItem(steak);
        Menuitem beer= new MenuItem(beer, 5.25);
        test1.addItem(beer);

        assertEquals( 125.75, test1.getTotalPrice());
    }
}
