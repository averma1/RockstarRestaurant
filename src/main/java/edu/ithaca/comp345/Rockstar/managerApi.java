package edu.ithaca.comp345.Rockstar;

public class managerApi {
    //TODO this will be changed to the stock of a real restaurant
    Stock managerStock = new Stock();

    public static void addIngredient(String name, double cost, int quantity){

    }

    public static void removeIngredient(String name){

    }

    public static Ingredient getIngredient(String nameToFind){
        return new Ingredient("asd", 123,123);
    }

    public static double getCostOfIngredient(String nameToFind){
        return -11;
    }

    public static int getQuantityOfIngredient(String nameToFind){
        return -11;
    }

    public static boolean isIngredientAvailable(String ingredientName){
        return false;
    }

}
