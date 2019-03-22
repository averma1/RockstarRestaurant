package edu.ithaca.comp345.Rockstar;

public class Ingredient {
    private String name;
    private double cost;
    private int quantity;

    public Ingredient(String nameIn, double costIn, int quantityIn){
        this.name = nameIn;
        this.cost = costIn;
        this.quantity = quantityIn;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getCost(){
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean checkIfAvailable(int amountNeeded) {
        if(amountNeeded + quantity >= 0)
            return true;
        return false;
    }

    public void changeQuantity(int amount) { //amount can be + or -
        if (checkIfAvailable(amount)){
            quantity = quantity + amount;
        }
        else{
            throw new IllegalArgumentException("The requested amount is not available");
        }
    }

    public void changeCost(double costIn){
        if (costIn < 0){
            throw new IllegalArgumentException("The cost is less than zero");
        }
        cost = costIn;
    }

    public static boolean isCostValid(double costIn){
        if (costIn < 0){
            return false;
        }
        return true;
    }
}
