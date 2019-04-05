package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String name;
    public static  List<Table> allTables;
    public waiterApi waiter;
    public hostApi host;
    private Stock stock = new Stock();
    private static int barNumber=420;
    public bartenderApi bartender;

    public Restaurant(){}

    public Restaurant(String name){
        allTables= new ArrayList<>();
        this.name=name;
        host= new hostApi();
        waiter= new waiterApi();
        bartender= new bartenderApi();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    /**
     * @param tableNumber: table number of the table to create
     * @param numOfSeats: number of seats at the table to create
     * creates a table
     */
    public static void createTable(int tableNumber, int numOfSeats){
        if(findTable(tableNumber)==-1) {
            Table table = new Table(tableNumber, numOfSeats);
            allTables.add(table);
        } else {
            throw new IndexOutOfBoundsException("Already a table with that number");
        }
    }

    /**
     * finds the position of the table in the master list of tables
     * @param table:table number of the table
     * @return returns the index of where the table number is at
     */
    public static int findTable(int table){
        int index=-1;
        for(int i=0; i<allTables.size(); i++){
            if(table==allTables.get(i).getTableNumber()){
                index=i;
            }
        }
        return index;
    }

    public static void createBar(int seatNumber){
        createTable(barNumber, seatNumber);
        bartenderApi.setSeats(seatNumber);
        bartenderApi.giveBar(allTables.get(findTable(420)));
    }
}
