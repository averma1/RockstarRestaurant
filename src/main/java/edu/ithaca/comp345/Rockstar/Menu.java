package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private HashMap<String, MenuItem> menuItemMap;
    private Stock stock;
    private String name;

    public Menu(String name, Stock stock){
        this.name = name;
        this.stock = stock;
        menuItemMap = new HashMap<>();
    }

    /**
     * adds a menu item to the menu based on a MenuItem object
     * @param item the MenuItem object to add
     */
    public void addMenuItem(MenuItem item){
        menuItemMap.put(item.getItemName(), item);
    }

    /**
     * removes a menu item based on the name of the item
     * @param name the name of the item to remove
     */
    public void removeMenuItem(String name){
        menuItemMap.remove(name);
    }

    /**
     * gets a MenuItem object based on the name of the menu item
     * @param name the name of the menu item to get
     * @return the MenuItem object that was found
     */
    public MenuItem getMenuItem(String name){
        return new MenuItem(new ArrayList<Ingredient>(), 4, "new dish");
    }

    /**
     * gets the name of the menu
     * @return the name of the menu
     */
    public String getName(){
        return name;
    }

    /**
     * get the Stock object in the menu
     * @return the Stock object
     */
    public Stock getStock(){
        return stock;
    }

    /**
     * gets the HashMap of MenuItem objects
     * @return the HashMap of MenuItem objects
     */
    public HashMap<String, MenuItem> getMenuItemMap(){
        return menuItemMap;
    }

}
