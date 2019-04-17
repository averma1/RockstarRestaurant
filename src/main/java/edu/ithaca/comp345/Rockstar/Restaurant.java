package edu.ithaca.comp345.Rockstar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public String name;
    public static  List<Table> allTables;
    public waiterApi waiter;
    public hostApi host;
    private Stock stock = new Stock();

    public Restaurant(){}

    public Restaurant(String name){
        allTables= new ArrayList<>();
        this.name=name;
        host= new hostApi();
        waiter= new waiterApi();
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

    public void loadTablesFromFile(String fileName) throws Exception{
        BufferedReader br = null;

        try
        {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("The file " + fileName + " doesn't exist!");
        }

        String st;
        while ((st = br.readLine()) != null){
            try {
                Table newTable = new Table(Integer.parseInt(st.substring(0,st.indexOf(","))), Integer.parseInt(st.substring(st.indexOf(",")+1)));
                allTables.add(newTable);
            }
            catch(StringIndexOutOfBoundsException | NumberFormatException e){
                System.out.println("Invalid Input: " + st);
            }
        }
    }
}
