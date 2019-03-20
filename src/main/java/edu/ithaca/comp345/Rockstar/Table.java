package edu.ithaca.comp345.Rockstar;

public class Table {
    public boolean isEmpty;
    private int numOfSeats;
    private int tableNumber;
    public boolean isMultiTable;

    public Table(){
        this.numOfSeats= 0;
        this.tableNumber= 0;
        isEmpty=true;
        isMultiTable=false;
    }

    public Table(int tableNumber, int numOfSeats){
        this.numOfSeats= numOfSeats;
        this.tableNumber= tableNumber;
        isEmpty=true;
        isMultiTable=false;
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