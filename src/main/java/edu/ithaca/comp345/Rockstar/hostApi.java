package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class hostApi {
    public static  List<Table> allTables= new ArrayList<>();

    public static void addTableToList(Table table){
        allTables.add(table);
    }

    public static Table pushTables(Table table1, Table table2){
        int index1= findTable(table1);
        int index2= findTable(table2);

        if(index1!=-1 && index2!=-1){
            int num= table1.getNumOfSeats()+table2.getNumOfSeats();
            Table newTable= new MultiTable(table1.getTableNumber(), num, table1.getNumOfSeats(), table2.getNumOfSeats());
            allTables.remove(index2);
            allTables.set(index1, newTable);
            return newTable;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public static Table splitTable(Table table){
        int index= findTable(table);
        if(table.isMultiTable){

        }

        return table;
    }

    public static void removeTable(Table table){
        int index=findTable(table);
        allTables.remove(index);
    }

    public static void clearTable(Table table){

    }

    public static void seatCustomers(Table table, int numOfPeople){
        if(numOfPeople<table.getNumOfSeats() && table.isTableEmpty()) {
            table.setNumOfSeatsFilled(numOfPeople);
            table.peopleSeated();
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public static void viewAllTables(){

    }

    public static void printTableData(Table table){

    }

    public static ArrayList<Table> searchTableBySize(int size){
        ArrayList<Table> tablesOfSize = new ArrayList<>();
        for(int i = 0; i < allTables.size(); i++){
            if(allTables.get(i).getNumOfSeats() == size){
                tablesOfSize.add(allTables.get(i));
            }
        }
        return tablesOfSize;
    }

    private static int findTable(Table table){
        int index=-1;
        for(int i=0; i<allTables.size(); i++){
            if(table.getTableNumber()==allTables.get(i).getTableNumber()){
                index=i;
            }
        }
        return index;
    }

}
