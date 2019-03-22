package edu.ithaca.comp345.Rockstar;

public class managerApi {
    //TODO this will be changed to the stock of a real restaurant
    public static Stock managerStock = new Stock();

    public static void addIngredient(String name, double cost, int quantity){
        managerStock.addIngredient(name, cost, quantity);
    }

    public static void removeIngredient(String name){
        managerStock.removeIngredient(name);
    }

    public static Ingredient getIngredient(String nameToFind){
        return managerStock.getIngredient(nameToFind);
    }

    public static double getCostOfIngredient(String nameToFind){
        return managerStock.getCost(nameToFind);
    }

    public static int getQuantityOfIngredient(String nameToFind){
        return managerStock.getQuantity(nameToFind);
    }

    public static boolean isIngredientAvailable(String ingredientName){
        return managerStock.isIngredientAvailable(ingredientName);
    }

}
