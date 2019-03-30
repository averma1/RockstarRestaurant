package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;

public class MenuItem {

    private double price;
    private ArrayList<Ingredient> ingredients;
    String itemName;

    public MenuItem(ArrayList<Ingredient> ingredients, double price, String itemName){
        this.price = price;
        this.itemName = itemName;
        this.ingredients = ingredients;
    }

    /**
     * adds an ingredient object to the list of ingredients for this menu item
     * @param ingredientToAdd the Ingredient object to add
     */
    public void addIngredient(Ingredient ingredientToAdd){
        ingredients.add(ingredientToAdd);
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

    }

    /**
     * gets the list of ingredients of the menu item
     * @return the list of ingredients
     */
    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
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
