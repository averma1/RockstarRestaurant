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

    /**
     * gets the name of the ingredient
     * @return the name of the ingredient
     */
    public String getName(){
        return name;
    }

    /**
     * sets the name of the ingredient
     * @param name the name to set the ingredient to
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * sets the cost of the ingredient
     * @param cost the cost to set the ingredient to
     */
    public void setCost(double cost){
        this.cost = cost;
    }

    /**
     * sets the quantity of the ingredient
     * @param quantity the quantity to set the ingredient to
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * gets the cost of the ingredient
     * @return the cost of the ingredient
     */
    public double getCost(){
        return cost;
    }

    /**
     * gets the quantity of the ingredient
     * @return the quantity of the ingredient
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * checks if the amount needed of an ingredient is currently available in the stock
     * @param amountNeeded the amount of the ingredient that is needed
     * @return a boolean - true if the amount is available or false if it is not
     */
    public boolean checkIfAvailable(int amountNeeded) {
        if(amountNeeded + quantity >= 0)
            return true;
        return false;
    }

    /**
     * changes the quantity of the ingredient and throws an exception if the amount is not available
     * @param amount the quantity to change to
     */
    public void changeQuantity(int amount) { //amount can be + or -
        if (checkIfAvailable(amount)){
            quantity = quantity + amount;
        }
        else{
            throw new IllegalArgumentException("The requested amount is not available");
        }
    }

    /**
     * changes the cost of the ingredient and throws an exception if the cost to change to is less than zero
     * @param costIn the cost to change to
     */
    public void changeCost(double costIn){
        if (costIn < 0){
            throw new IllegalArgumentException("The cost is less than zero");
        }
        cost = costIn;
    }

    /**
     * checks if a cost is greater than zero or valid
     * @param costIn the cost to check
     * @return a boolean - true if the cost is valid or false if it is not
     */
    public static boolean isCostValid(double costIn){
        if (costIn < 0){
            return false;
        }
        return true;
    }
}
