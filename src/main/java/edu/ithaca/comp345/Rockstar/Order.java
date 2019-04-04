package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public int number; //order number
    protected List<MenuItem> items= new ArrayList<>(); //list of menu items

    public Order(int num){
        number=num;
    }


    /**
     * gets order number
     * @return: order number
     */
    public int getNumber(){
        return number;
    }


    /**
     * sets order number
     * @param num: new order number to be set
     */
    public void setNumber(int num){
        number=num;
    }


    /**
     * gets all the items of the order
     * @return: items, list of items
     */
    public List<MenuItem> getItems(){
        return items;
    }

    /**
     * adds menu item to the list of items in the order
     * @param item: item to be added
     */
    public void addItem(MenuItem item){
        items.add(item);
    }


    /**
     * returns the total price of everything in the order
     * @return price: total price of all items
     */
    public double getTotalPrice(){
        double price=0;
        for(int i=0; i<items.size(); i++){
            price+=items.get(i).getPrice();
        }
        return price;
    }
}
