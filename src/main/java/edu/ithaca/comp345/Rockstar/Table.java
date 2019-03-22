package edu.ithaca.comp345.Rockstar;

public class Table {
    private boolean isEmpty;
    private int numOfSeats;
    private int filledSeats;
    private int tableNumber;
    public boolean isMultiTable;

    public Table(){
        this.numOfSeats= 0;
        this.tableNumber= 0;
        isEmpty=true;
        isMultiTable=false;
        filledSeats=0;
    }

    public Table(int tableNumber, int numOfSeats){
        this.numOfSeats= numOfSeats;
        this.tableNumber= tableNumber;
        filledSeats=0;
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

    public int getNumOfSeatsFilled(){
        return this.filledSeats;
    }
    public int setNumOfSeatsFilled(int numOfSeats){
        this.filledSeats=numOfSeats;
        return this.filledSeats;
    }

    public void peopleSeated(){isEmpty=false;}

    public void clearTable(){isEmpty=true;}

    public boolean isTableEmpty(){ return isEmpty ;}

}