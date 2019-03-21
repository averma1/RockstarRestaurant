package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class hostApi {
    public static  List<Table> allTables= new ArrayList<>();
    public static  List<MultiTable> MultiTables= new ArrayList<>();

    public static void createTable(int tableNumber, int numOfSeats){
        Table table= new Table(tableNumber, numOfSeats);
        allTables.add(table);
    }

    public static MultiTable pushTables(int table1, int table2){
        int index1= findTable(table1);
        int index2= findTable(table2);

        if(index1!=-1 && index2!=-1){
            int num= allTables.get(index1).getNumOfSeats()+allTables.get(index2).getNumOfSeats();
            MultiTable newTable= new MultiTable(allTables.size()+1, allTables.get(index1), allTables.get(index2));
            allTables.remove(index2);
            allTables.remove(index1);
            allTables.add(newTable);
            MultiTables.add(newTable);
            return newTable;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public static void splitTable(int tableNum){
        int index= findTable(tableNum);
        if(allTables.get(index).isMultiTable){
            int index2= findInMulti(tableNum);
            for(int i=0; i<MultiTables.get(index2).tables.size(); i++){
                Table table= new Table(MultiTables.get(index2).tables.get(i).getTableNumber(), MultiTables.get(index2).tables.get(i).getNumOfSeats());
                allTables.add(table);
            }
            allTables.remove(index);
            MultiTables.remove(index2);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void removeTable(int tableNum){
        int index=findTable(tableNum);
        allTables.remove(index);
    }

    public static void clearTable(int tableNum){
        int index=findTable(tableNum);
        allTables.get(index).setNumOfSeatsFilled(0);
        allTables.get(index).clearTable();
    }

    public static void seatCustomers(int tableNum, int numOfPeople){
        int index=findTable(tableNum);
        if(numOfPeople<allTables.get(index).getNumOfSeats() && allTables.get(index).isTableEmpty()) {
            allTables.get(index).setNumOfSeatsFilled(numOfPeople);
            allTables.get(index).peopleSeated();
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public static void viewAllTables(){
        //calls printTableData on all tables
        int myTableNum = 0;
        for(int i = 0; i < allTables.size(); i++){
            myTableNum = allTables.get(i).getTableNumber();
            printTableData(myTableNum);
        }
    }

    public static String printTableData(int tableNum){
        int index=findTable(tableNum);
        return ("Table number: "+allTables.get(index).getTableNumber()+", Number of Seats: "+allTables.get(index).getNumOfSeats()+", Available: "+allTables.get(index).isTableEmpty());
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

    private static int findTable(int table){
        int index=-1;
        for(int i=0; i<allTables.size(); i++){
            if(table==allTables.get(i).getTableNumber()){
                index=i;
            }
        }
        return index;
    }

    private static int findInMulti(int table){
        int index=-1;
        for(int i=0; i<MultiTables.size(); i++){
            if(table==MultiTables.get(i).getTableNumber()){
                index=i;
            }
        }
        return index;
    }


}
