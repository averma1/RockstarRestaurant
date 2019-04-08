package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private HashMap<String, MenuItem> menuItemMap;
    private Stock stock;
    private String name;

    public Menu(String name, Stock stock){

    }

    public void addMenuItem(MenuItem item){

    }

    public void removeMenuItem(String name){

    }

    public MenuItem getMenuItem(String name){
        return new MenuItem(new ArrayList<Ingredient>(), 4, "new dish");
    }

    public String getName(){
        return name;
    }

    public Stock getStock(){
        return stock;
    }

}
