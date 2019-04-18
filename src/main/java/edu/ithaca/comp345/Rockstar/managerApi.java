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

    private boolean isPinValid(int pin){
        int length = (int) (Math.log10(pin) + 1);
        if(length==4) {
            if (!pins.containsKey(pin)) {
                return true;
            }
        }
        return false;
    }

    public static void removeEmployee(int pin, String name){

    }

    public static void changeEmployeePin(int pinOld, String name, int pinNew){

    }

    public static void changeEmployeeType(int pin, String name, String typeNew){

    }

    private int findEmployee(String name){
        int index=-1;
        for(int i=0; i<employees.size(); i++){
            if(name==employees.get(i).getName()){
                index=i;
            }
        }
        return index;
    }

    public void assignTablesToWaiter(int pin, String Name, Table tablenum){

    }

    public void removeTablesFromWaiter(int pin, String Name, Table tablenum){

    }


}
