package edu.ithaca.comp345.Rockstar;

public class Table {
    private int numOfSeats;
    private int tableNumber;
    public Table(int tableNumber, int numOfSeats){
        this.numOfSeats= numOfSeats;
        this.tableNumber= tableNumber;
    }
    public int getTableNumber(){
        return this.tableNumber;
    }
    public int setTableNumber(int tableNumber){
        this.tableNumber=tableNumber;
        return this.tableNumber;
    }

    public int getNumOfSeats(){
        return this.numOfSeats;
    }
    public int setNumOfSeats(int numOfSeats){
        this.numOfSeats=numOfSeats;
        return this.numOfSeats;
    }


}