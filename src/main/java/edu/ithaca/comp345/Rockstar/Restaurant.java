package edu.ithaca.comp345.Rockstar;

import java.io.*;
import java.util.*;

public class Restaurant {
    public String name;
    public static  List<Table> allTables;
    public waiterApi waiter;
    public hostApi host;
    public static Stock stock;
    private static int barNumber=420;
    public BartenderApi bartender;
    public Menu menu;
    public static List<Employee> employees;
    public static List<Integer> pins;
    public managerApi manager;
    public static HashMap<Employee, List<Table>> waiters;

    Restaurant(){}

    public final String defaultStockFileName = "";
    public final String defaultTableFileName = "";
    public final String defaultMenuFileName = "";
    public final String defaultPinFileName = "";

    public Restaurant(String name, String stockFileName, String tableFileName, String menuFileName, String employeeFileName) throws Exception{
        allTables= new ArrayList<>();
        this.name=name;
        host= new hostApi();
        waiter= new waiterApi();
        bartender= new BartenderApi();
        stock= new Stock();
        menu= new Menu("main", stock);
        employees= new ArrayList<>();
        pins= new ArrayList<>();
        manager= new managerApi();
        waiters= new HashMap<>();

        //load from file
        this.loadTablesFromFile(tableFileName);
        stock.loadFromFile(stockFileName);
        menu.loadMenuFromFile(menuFileName);
        this.loadPinsFromFile(employeeFileName);
    }

    public void saveRestaurantToFile(String stockFileName, String tableFileName, String menuFileName, String employeeFileName) throws Exception{
        savePinsToFile(employeeFileName);
        stock.saveStockToFile(stockFileName);
        saveTablesToFile(tableFileName);
        menu.saveMenuToFile(menuFileName);

    }

    public Restaurant(String name){
        allTables= new ArrayList<>();
        this.name=name;
        host= new hostApi();
        waiter= new waiterApi();
        bartender= new BartenderApi();
        stock= new Stock();
        menu= new Menu("main", stock);
        employees= new ArrayList<>();
        pins= new ArrayList<>();
        manager= new managerApi();
        waiters= new HashMap<>();

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
                createTable(Integer.parseInt(st.substring(0,st.indexOf(","))), Integer.parseInt(st.substring(st.indexOf(",")+1)));
            }
            catch(StringIndexOutOfBoundsException | NumberFormatException e){
                System.out.println("Invalid Input: " + st);
            }
        }
    }

    public void saveTablesToFile(String filename) throws Exception{

        FileWriter fileWriter = new FileWriter(filename);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int i = 0;i<allTables.size();i++){
            printWriter.println(allTables.get(i).getTableNumber() + "," + allTables.get(i).getNumOfSeats());
        }

        printWriter.close();

    }

    public static void createBar(int seatNumber){
        createTable(barNumber, seatNumber);
        BartenderApi.setBar(barNumber);
        BartenderApi.setSeats(seatNumber);
    }

    public static int findEmployee(int pin){
        int index=-1;
        for(int i=0; i<employees.size(); i++){
            if(pin==employees.get(i).getPin()) {
                index = i;
            }
        }
        return index;
    }

    public static void saveToFile(String fileName){

    }

    public static void savePinsToFile(String fileName) throws Exception{
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        Iterator<Employee> empItr = employees.iterator();
        while(empItr.hasNext()){
            Employee currEmployee = empItr.next();
            printWriter.println(currEmployee.getPin() + "#" + currEmployee.getName() + "$" + currEmployee.getType());
        }
        printWriter.close();
    }

    public static void loadPinsFromFile(String fileName) throws Exception{
        BufferedReader br = null;
        try {
            File file = new File(fileName);
            br = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException("The file " + fileName + " doesn't exist!");
        }

        String st;
        int pin;
        String name;
        String type;
        while((st = br.readLine()) != null){
            try{
                pin = Integer.parseInt(st.substring(0, st.indexOf('#')));
                name = st.substring(st.indexOf('#')+1, st.indexOf('$'));
                type = st.substring(st.indexOf('$')+1);
                managerApi.addEmployee(pin, name, type);
            }
            catch(StringIndexOutOfBoundsException | NumberFormatException e){
                System.out.println("Invalid Input: " + st);
            }
        }
    }

    public boolean isLoginPinValid(int pinIn){
        if(pins.contains(pinIn))
            return true;
        else
            return false;
    }

}
