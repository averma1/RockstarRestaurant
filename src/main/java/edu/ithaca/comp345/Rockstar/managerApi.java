package edu.ithaca.comp345.Rockstar;

public class managerApi extends Restaurant{
    public static void addIngredient(String name, double cost, int quantity){
        stock.addIngredient(name, cost, quantity);
    }

    public static void removeIngredient(String name){
        stock.removeIngredient(name);
    }

    public static Ingredient getIngredient(String nameToFind){
        return stock.getIngredient(nameToFind);
    }

    public static double getCostOfIngredient(String nameToFind){
        return stock.getCost(nameToFind);
    }

    public static int getQuantityOfIngredient(String nameToFind){
        return stock.getQuantity(nameToFind);
    }

    public static boolean isIngredientAvailable(String ingredientName){
        return stock.isIngredientAvailable(ingredientName);
    }

    public static void addEmployee(int pin, String name, String type){

    }

    private static boolean isPinValid(int pin){
        return true;
    }

    public static void removeEmployee(int pin, String name){

    }

    public static void changeEmployeePin(int pinOld, String name, int pinNew){

    }

    public static void changeEmployeeType(int pin, String name, String typeNew){

    }

    private int findEmployee(String name){
        return -1;
    }


}
