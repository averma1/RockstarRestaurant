package edu.ithaca.comp345.Rockstar;


import java.util.HashMap;

public class Stock {
    private HashMap<String, Ingredient> ingredientMap;

    public Stock(){
        ingredientMap = new HashMap<>();
    }

    public void addIngredient(String name, double cost, int quantity){
        ingredientMap.put(name, new Ingredient(name, cost, quantity));
    }

    public Ingredient getIngredient(String nameToFind){
        return ingredientMap.get(nameToFind);
    }

    public double getCost(String nameToFind){
        return ingredientMap.get(nameToFind).getCost();
    }

    public int getQuantity(String nameToFind){
        return ingredientMap.get(nameToFind).getQuantity();
    }

    public void removeIngredient(String nameToFind){
        ingredientMap.remove(nameToFind);
    }

    public void changeIngredientName(String nameToFind, String changeTo){
        //TODO
    }

    public void changeIngredientCost(String nameToFind, double cost){
        //TODO
    }

    public void changeIngredientQuantity(String nameToFind, int quantity){
        //TODO
    }

    public HashMap getIngredientsList(){
        return ingredientMap;
    }

    public boolean isIngredientAvailable(String nameToFind){
        return ingredientMap.containsKey(nameToFind);
    }

}
