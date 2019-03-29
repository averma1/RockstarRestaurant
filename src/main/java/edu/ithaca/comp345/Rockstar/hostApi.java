package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.List;

public class hostApi {

    public static  List<Table> allTables;
    public static  List<MultiTable> MultiTables;
    public static List<Party> waitlist;

    public hostApi(){
        allTables= new ArrayList<>();
        MultiTables=new ArrayList<>();
        waitlist= new ArrayList<>();
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
     * @param table1: first table to push
     * @param table2: second table to push against first table
     * @return Multitable: creates a multitable and returns this table
     */
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
            throw new IndexOutOfBoundsException("One or both of those tables do not exist");
        }
    }
    /**
     * @param tableNum: table number of the table to split
     * splits the table that was pushed together
     * after this is run, there should be 2 tables once again
     */
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
            throw new IndexOutOfBoundsException("That table is not a multitable");
        }
    }

    /**
     * @param tableNum: table number of the table to remove
     * removes a table from master list of tables
     */
    public static void removeTable(int tableNum){
        if(findTable(tableNum)!=-1) {
            int index = findTable(tableNum);
            allTables.remove(index);
        } else {
            throw new IndexOutOfBoundsException("That table does not exist");
        }
    }

    /**
     * @param tableNum: table number of the table to clear
     * clears the table: sets the number of seats filled at that table back to 0
     */
    public static void clearTable(int tableNum){
        if(findTable(tableNum)!=-1) {
            int index=findTable(tableNum);
            allTables.get(index).setNumOfSeatsFilled(0);
            allTables.get(index).clearTable();
        } else {
            throw new IndexOutOfBoundsException("That table does not exist");
        }
    }

    /**
     * @param tableNum: table number of the table to seat people at
     * @param numOfPeople: number of people to seat
     * seats customers to a certain table: sets the number of seats filled to the number of people to seat
     */
    public static void seatCustomers(int tableNum, int numOfPeople){
        int index=findTable(tableNum);
        if(numOfPeople<allTables.get(index).getNumOfSeats() && allTables.get(index).isTableEmpty()) {
            allTables.get(index).setNumOfSeatsFilled(numOfPeople);
            allTables.get(index).peopleSeated();
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * prints out all the tables
     * @return returns the number of tables there are in the master table list
     */
    public static int viewAllTables(){
        int myTableNum = 0;
        int count = 0;
        for(int i = 0; i < allTables.size(); i++){
            myTableNum = allTables.get(i).getTableNumber();
            printTableData(myTableNum);
            count++;
        }
        return count;
    }

    /**
     * @param tableNum: table number to print data for
     * prints all the data for the specific table entered
     */
    public static void printTableData(int tableNum){
        int index=findTable(tableNum);
        System.out.println(("Table number: "+allTables.get(index).getTableNumber()+", Number of Seats: "+allTables.get(index).getNumOfSeats()+", Available: "+allTables.get(index).isTableEmpty()));
    }

    /**
     * @param size: size of the table
     * searches the entire table list to find tables that are of the size specified
     * @return returns a list of tables that are of the size specified
     */
    public static ArrayList<Table> searchTableBySize(int size){
        ArrayList<Table> tablesOfSize = new ArrayList<>();
        for(int i = 0; i < allTables.size(); i++){
            if(allTables.get(i).getNumOfSeats() == size){
                tablesOfSize.add(allTables.get(i));
            }
        }
        return tablesOfSize;
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

    /**
     * returns the position of the table in the list of multi tables
     * @param table: table number of the multi table
     * @return returns the index of where the table number is at
     */
    public static int findInMulti(int table){
        int index=-1;
        for(int i=0; i<MultiTables.size(); i++){
            if(table==MultiTables.get(i).getTableNumber()){
                index=i;
            }
        }
        return index;
    }

    /**
     * finds the total amount of seats in the restaurant
     * @return returns the the total amount of seats
     */
    private static int getTotalSeats(){
        int seats=0;
        for(int i=0; i<allTables.size(); i++){
            seats+=allTables.get(i).getNumOfSeats();
        }
        return seats;
    }

    /**
     * finds the position of the party in the waitlist
     * @param name: String name of the party to sinf
     * @return returns the index of where the party number is at
     */
    public static int findParty(String name){
        int index= -1;
        for(int i=0; i<waitlist.size(); i++){
            if(waitlist.get(i).name==name){
                index=i;
            }
        }
        return index;
    }

    /**
     * creates a new party and adds it to the end of the waitlist
     * @param name: String name of the party
     *        number: int number of people in the party
     */
    public static void addToWaitlist(String name, int number){
        if(number<=0 || number>getTotalSeats()){
            throw new IndexOutOfBoundsException("Invalid number");
        }
        if(findParty(name)==-1) {
            Party partyNew = new Party(name, number);
            waitlist.add(partyNew);
        } else {
            throw new IndexOutOfBoundsException("Invalid name");
        }
    }

    /**
     * remove the first party from the waitlist
     * @param size: int size of the party to remove
     */
    public static Party removeFromWaitlist(int size){
        for(int i=0; i<waitlist.size(); i++) {
            if(waitlist.get(i).number==size) {
                Party removed = waitlist.get(i);
                waitlist.remove(removed);
                return removed;
            }
        }
        return null;
    }

    /**
     * @return returns the entire waitlist
     */
    public static List<Party> viewWaitlist(){
        return waitlist;
    }


}
