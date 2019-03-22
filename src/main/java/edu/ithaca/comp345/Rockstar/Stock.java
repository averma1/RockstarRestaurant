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

         Ingredient ingredient = ingredientMap.get(nameToFind);
         double cost = ingredient.getCost();
         int quantity = ingredient.getQuantity();

         Ingredient newIngredient = new Ingredient(changeTo, cost, quantity);

         ingredientMap.remove(nameToFind);
         ingredientMap.put(changeTo, newIngredient);
    }

    public void changeIngredientCost(String nameToFind, double cost){
        ingredientMap.get(nameToFind).setCost(cost);
    }

    public void changeIngredientQuantity(String nameToFind, int quantity){
        ingredientMap.get(nameToFind).setQuantity(quantity);
    }

    public HashMap getIngredientsList(){
        return ingredientMap;
    }

    public boolean isIngredientAvailable(String nameToFind){
        return ingredientMap.containsKey(nameToFind);
    }

}
