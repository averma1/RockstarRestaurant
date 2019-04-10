package edu.ithaca.comp345.Rockstar;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public void addMenuItem(MenuItem item)
    {
        menuItemMap.put(item.getItemName(), item);
    }

    /**
     * removes a menu item based on the name of the item
     * @param name the name of the item to remove
     */
    public void removeMenuItem(String name){
        if (isNameValid(name)) {
            menuItemMap.remove(name);
        }
        else{
            throw new IllegalArgumentException("The item does not exist");
        }
    }

    /**
     * gets a MenuItem object based on the name of the menu item
     * @param name the name of the menu item to get
     * @return the MenuItem object that was found
     */
    public MenuItem getMenuItem(String name){
        if (isNameValid(name))
        {
            return menuItemMap.get(name);
        }
        else{
            throw new IllegalArgumentException("The item does not exist");
        }

    }

    /**
     * determines if a given name is present in the HashMap
     * @param name the name of the menu item to find
     * @return true of the menu item exists and false if it does not
     */
    public boolean isNameValid(String name){
        if (menuItemMap.containsKey(name)){
            return true;
        }
        return false;
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

    public void loadMenuFromFile(String fileName) throws IOException {
        BufferedReader br = null;

        try
        {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("The file " + fileName + " doesn't exist!");
        }

        String st;
        String menuItemName;
        double menuItemCost;
        HashMap<Ingredient, Integer> ingredients;

        while((st = br.readLine()) != null){
            ingredients = new HashMap<>();
            menuItemName = "";
            try{
                if(st.charAt(0) == '@')
                {
                    menuItemName = st.substring(1);
                }
                st = br.readLine();
                if(st.charAt(0) == '$')
                {
                    menuItemCost = Double.parseDouble(st.substring(1));

                    while((st = br.readLine()) != null && st.charAt(0) == '-') //get all the ingredients
                    {
                        Ingredient ingredientToAdd = stock.getIngredient(st.substring(1, st.indexOf(',')));
                        int ingredientQuantity = Integer.parseInt(st.substring(st.indexOf(',') + 1));
                        ingredients.put(ingredientToAdd, ingredientQuantity);
                    }

                    //create the menuItem
                    MenuItem newMenuItem = new MenuItem(menuItemName, menuItemCost);

                    //add all the ingredients
                    for(Map.Entry<Ingredient, Integer> currIngredientEntry : ingredients.entrySet()){
                        newMenuItem.addIngredient(currIngredientEntry.getKey(), currIngredientEntry.getValue());
                    }

                    addMenuItem(newMenuItem);
                }
            }
            catch(StringIndexOutOfBoundsException | IllegalArgumentException e){
                System.out.println("Invalid Input: " + st);
            }
        }
    }
}
