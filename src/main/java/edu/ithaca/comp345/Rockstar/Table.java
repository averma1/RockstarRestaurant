package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class Table {
    public List<Order> orders= new ArrayList<>();
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

    /**
     * creates a table
     * @param tableNumber
     * @param numOfSeats
     */
    public Table(int tableNumber, int numOfSeats){
        this.numOfSeats= numOfSeats;
        this.tableNumber= tableNumber;
        filledSeats=0;
        isEmpty=true;
        isMultiTable=false;
    }

    /**
     * gets the table number
     * @return returns table number
     */
    public int getTableNumber(){
        return this.tableNumber;
    }

    /**
     * sets the table number
     * @param tableNumber: table number to set
     * @return returns table number
     */
    public int setTableNumber(int tableNumber){
        this.tableNumber=tableNumber;
        return this.tableNumber;
    }

    /**
     * gets the number of seats
     * @return returns the number of seats
     */
    public int getNumOfSeats(){
        return this.numOfSeats;
    }

    /**
     * sets the number of sears
     * @param numOfSeats: number of seats to be set
     * @return number of seats
     */
    public int setNumOfSeats(int numOfSeats){
        this.numOfSeats=numOfSeats;
        return this.numOfSeats;
    }

    /**
     * gets the number of seats filled
     * @return returns the number of seats that are filled
     */
    public int getNumOfSeatsFilled(){
        return this.filledSeats;
    }

    /**
     * sets the number of seats that are filled
     * @param numOfSeats: the number of seats that are filled
     * @return returns the number of seats filled
     */
    public int setNumOfSeatsFilled(int numOfSeats){
        this.filledSeats=numOfSeats;
        return this.filledSeats;
    }


    /**
     * sets the table to be no longer empty
     * @return returns that the table is no longer empty
     */
    public void peopleSeated(){isEmpty=false;}


    /**
     * sets the table to be empty
     * @return returns that the table is empty
     */
    public void clearTable(){isEmpty=true;}


    /**
     * checks to see if the table is empty or not
     * @return returns the the table is empty or not
     */
    public boolean isTableEmpty(){ return isEmpty ;}

    public int findOrder(int number){

    }

    public void createOrder(int number){

    }

    public void addtoOrder(MenuItem item, int number){

    }

    public List<MenuItems> getItems(int number){

    }

    public double getOrderPrice(int number){

    }

    public double getOrdersTotalPrice(){

    }
}