package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuItem {

    private double price;
    String itemName;
    HashMap<Ingredient, Integer> ingredients;

    public MenuItem(String itemName, double price){
        this.price = price;
        this.itemName = itemName;
        ingredients = new HashMap<>();
    }

    /**
     * adds an ingredient object to the list of ingredients for this menu item
     * @param ingredientToAdd the Ingredient object to add
     */
    public void addIngredient(Ingredient ingredientToAdd, int amountUsed){
        ingredients.put(ingredientToAdd, amountUsed);
    }

    /**
     * removes an ingredient from the list of ingredients for this menu item
     * @param ingredientToRemove the ingredient object to remove
     */
    public void removeIngredient(Ingredient ingredientToRemove){
        ingredients.remove(ingredientToRemove);
    }

    /**
     * changes the price of the menu item
     * @param newPrice the new price to set for the menuItem
     */
    public void changePrice(double newPrice){
        this.price = newPrice;
    }

    /**
     * gets the list of ingredients of the menu item
     * @return the list of ingredients
     */
    public ArrayList<Ingredient> getIngredients(){
        ArrayList<Ingredient> toReturn = new ArrayList<>();
        for(Ingredient currIngredient : ingredients.keySet())
            toReturn.add(currIngredient);
        return toReturn;
    }

    public Ingredient getIngredient(String ingredientName){
        for(Ingredient currIngredient : ingredients.keySet())
            if(currIngredient.getName() == ingredientName)
                return currIngredient;
        //ingredient doesn't exist
        return null;
    }

    /**
     * gets the price of the menu item
     * @return the price of the menu item
     */
    public double getPrice(){
        return price;
    }

    /**
     * gets the name of the menu item
     * @return the name of the menu item
     */
    public String getItemName(){
        return itemName;
    }

}
