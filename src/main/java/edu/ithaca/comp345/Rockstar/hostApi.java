package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class hostApi {
    public static  List<Table> allTables= new ArrayList<>();

    public static Table pushTables(Table table1, Table table2){
        int index1= findTable(table1);
        int index2= findTable(table2);

        if(index1!=-1 && index2!=-1){
            int num= table1.getNumOfSeats()+table2.getNumOfSeats();
            Table newTable= new Table(table1.getTableNumber(), num);
            return newTable;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public static Table splitTable(Table table){

        return
    }

    public static void removeTable(Table table){

    }

    public static void clearTable(Table table){

    }

    public static void seatCustomers(Table table, int numOfPeople){

    }

    public static void viewAllTables(){

    }

    public static void printTabledata(Table table){

    }

    public static void searchTableBySize(int size){

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
