package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public int number;
    protected List<MenuItem> items= new ArrayList<>();

    public Order(int num){
        number=num;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int num){
        number=num;
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public double getTotalPrice(){
        double price=0;
        for(int i=0; i<items.size(); i++){
            price+=items.get(i).getPrice();
        }
        return price;
    }
}
