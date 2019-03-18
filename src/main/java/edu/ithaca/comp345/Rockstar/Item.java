package edu.ithaca.comp345.Rockstar;

public class Item {
    public String name;
    public double cost;
    public int quantity;

    public Item(String nameIn, double costIn, int quantityIn){
        this.name = nameIn;
        this.cost = costIn;
        this.quantity = quantityIn;
    }

    public String getName(){
        return name;
    }

    public double getCost(){
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean checkIfAvailable(int amountNeeded) {
        //TODO
        return false;
    }

    public void changeQuantity(int amount) { //amount can be + or -
        //TODO check if amount is available?
        quantity = quantity + amount;
    }

    public void changeCost(double costIn){
        cost = costIn;
    }

    public boolean isCostValid(double costIn){
        //TODO
        return false;
    }
}
