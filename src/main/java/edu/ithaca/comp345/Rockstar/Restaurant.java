package edu.ithaca.comp345.Rockstar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    public String name;
    public static  List<Table> allTables;
    public waiterApi waiter;
    public hostApi host;
    public static Stock stock;
    private static int barNumber=420;
    public bartenderApi bartender;
    public Menu menu;
    public static List<Employee> employees;
    public static List<Integer> pins;
    public managerApi manager;
    public static HashMap<Employee, List<Table>> waiters;


    public Restaurant(){}

    public Restaurant(String fileName, int nothing){
        allTables= new ArrayList<>();
        this.name=fileName;
        host= new hostApi();
        waiter= new waiterApi();
        bartender= new bartenderApi();
        createBar(50);
        stock= new Stock();
        menu= new Menu("main", stock);

        createTable(2, 10);

        stock.addIngredient("ravioli", .50, 20);
        stock.addIngredient("chicken", .50, 60);
        stock.addIngredient("breadSticks", .50, 350);

        MenuItem item1= new MenuItem("chicken parm", 10);
        item1.addIngredient(stock.getIngredient("chicken"), 10);
        MenuItem item2= new MenuItem("cheese ravioli", 10);
        item2.addIngredient(stock.getIngredient("ravioli"), 5);
        MenuItem item3= new MenuItem("bread sticks", 10);
        item3.addIngredient(stock.getIngredient("breadSticks"), 50);
        MenuItem item4= new MenuItem("coffee", 10);
        MenuItem item5= new MenuItem("chocolate cake", 10);
        MenuItem item6= new MenuItem("beer", 10);

        menu.addMenuItem(item1);
        menu.addMenuItem(item2);
        menu.addMenuItem(item3);
        menu.addMenuItem(item4);
        menu.addMenuItem(item5);
        menu.addMenuItem(item6);

        bartender.barStock.addIngredient("tequila", .50, 20);
        bartender.barStock.addIngredient("beer", .50, 60);
        bartender.barStock.addIngredient("soup", .50, 350);

        MenuItem item7= new MenuItem("margarita", 10);
        item7.addIngredient(bartender.barStock.getIngredient("tequila"), 5);
        MenuItem item8= new MenuItem("red wine", 10);
        MenuItem item9= new MenuItem("soup", 10);
        item9.addIngredient(bartender.barStock.getIngredient("soup"), 50);
        MenuItem item10= new MenuItem("coffee", 10);
        MenuItem item11= new MenuItem("mojito", 10);
        MenuItem item12= new MenuItem("beer", 10);
        item12.addIngredient(bartender.barStock.getIngredient("beer"), 10);

        bartender.barMenu.addMenuItem(item7);
        bartender.barMenu.addMenuItem(item8);
        bartender.barMenu.addMenuItem(item9);
        bartender.barMenu.addMenuItem(item10);
        bartender.barMenu.addMenuItem(item11);
        bartender.barMenu.addMenuItem(item12);
    }

    public Restaurant(String name){
        allTables= new ArrayList<>();
        this.name=name;
        host= new hostApi();
        waiter= new waiterApi();
        bartender= new bartenderApi();
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

    public static void createBar(int seatNumber){
        createTable(barNumber, seatNumber);
        bartenderApi.setBar(barNumber);
        bartenderApi.setSeats(seatNumber);
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

}
