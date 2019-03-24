package edu.ithaca.comp345.Rockstar;


import java.util.HashMap;

public class Stock {
    private HashMap<String, Ingredient> ingredientMap;

    public Stock(){
        ingredientMap = new HashMap<>();
    }

    /**
     * creates a new ingredient object and adds it to to the HashMap
     * @param name the name of the ingredient to use
     * @param cost the cost of the ingredient to use
     * @param quantity the quantity of the ingredient to use
     */
    public void addIngredient(String name, double cost, int quantity){
        ingredientMap.put(name, new Ingredient(name, cost, quantity));
    }

    /**
     * gets an ingredient object based on the key
     * @param nameToFind the name of the ingredient or key
     * @return the Ingredient object found
     */
    public Ingredient getIngredient(String nameToFind){
        return ingredientMap.get(nameToFind);
    }

    /**
     * gets the cost of an Ingredient object
     * @param nameToFind the name of the ingredient or key to find the object
     * @return the cost of the ingredient
     */
    public double getCost(String nameToFind){
        return ingredientMap.get(nameToFind).getCost();
    }

    /**
     * get the quantity of a specified Ingredient object
     * @param nameToFind the name of the ingredient or key to find the object
     * @return the quantity of the object
     */
    public int getQuantity(String nameToFind){
        return ingredientMap.get(nameToFind).getQuantity();
    }

    /**
     * removes an ingredient from the HashMap based on the name
     * @param nameToFind the name of the ingredient or key to find the object
     */
    public void removeIngredient(String nameToFind){
        ingredientMap.remove(nameToFind);
    }

    /**
     * changes the name of a specified ingredient
     * @param nameToFind the name of the ingredient or key to find the object
     * @param changeTo the name to change the object to
     */
    public void changeIngredientName(String nameToFind, String changeTo){

         Ingredient ingredient = ingredientMap.get(nameToFind);
         double cost = ingredient.getCost();
         int quantity = ingredient.getQuantity();

         Ingredient newIngredient = new Ingredient(changeTo, cost, quantity);

         ingredientMap.remove(nameToFind);
         ingredientMap.put(changeTo, newIngredient);
    }

    /**
     * changes the cost of the specified ingredient
     * @param nameToFind the name of the ingredient or key to find the object
     * @param cost the cost to change the object to
     */
    public void changeIngredientCost(String nameToFind, double cost){
        ingredientMap.get(nameToFind).setCost(cost);
    }

    /**
     * changes the quantity of the specified ingredient
     * @param nameToFind the name of the ingredient or key to find the object
     * @param quantity the quantity to change the object to
     */
    public void changeIngredientQuantity(String nameToFind, int quantity){
        ingredientMap.get(nameToFind).setQuantity(quantity);
    }

    /**
     * gets the HashMap of Ingredient objects
     * @return the HashMap of Ingredient objects
     */
    public HashMap getIngredientsList(){
        return ingredientMap;
    }

    /**
     * checks if the specified ingredient exists in the HashMap
     * @param nameToFind the name of the ingredient or key to find the object
     * @return a boolean - true if the object exists or false if it does not
     */
    public boolean isIngredientAvailable(String nameToFind){
        return ingredientMap.containsKey(nameToFind);
    }

}
