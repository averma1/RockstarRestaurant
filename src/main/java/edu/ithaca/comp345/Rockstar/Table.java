package edu.ithaca.comp345.Rockstar;

public class Table {
    public boolean isEmpty;
    private int numOfSeats;
    private int tableNumber;
    public Table(int tableNumber, int numOfSeats){
        this.numOfSeats= numOfSeats;
        this.tableNumber= tableNumber;
        isEmpty=true;
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

    public void peopleSeated(){
        isEmpty=false;
    }


}