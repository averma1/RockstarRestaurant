package edu.ithaca.comp345.Rockstar;


import java.lang.reflect.InaccessibleObjectException;
import java.util.HashMap;
import java.util.List;

public class BartenderApi extends WaiterApi {
    public int seats;
    public static int bar;
    public Stock barStock;
    public Menu barMenu;

    public BartenderApi(){
        seats= 0;
        bar= 0;
        barStock= new Stock();
        barMenu= new Menu("bar", barStock);

    }

    /**
     * adds an item to a given order
     * @param orderNum
     * @param item item to add
     */
    public void addToOrder(int orderNum, String item){
        Table barTable= allTables.get(findTable(bar));
        if(barTable.findOrder(orderNum)==-1){
            barTable.createOrder(orderNum);
        }
        MenuItem Item = barMenu.getMenuItem(item);
        if (barStock != null) {
            barStock.removeMenuItem(Item);
        }
        barTable.addtoOrder(Item, orderNum);
    }

    /**
     * allows the user to pay
     * @param orderNum
     * @return: price to pay
     */
    public double pay(int orderNum){
        Table barTable= allTables.get(findTable(bar));

        double price= barTable.getOrderPrice(orderNum);
        barTable.removeOrder(orderNum);

        int current= barTable.getFilledSeats();
        barTable.setFilledSeats(current-1);
        return price;
    }

    /**
     * splits the bill by a given number
     * @param split:
     * @return
     */
    public static double splitBillByTotal(int split){
        int index= findTable(bar);
        if(index!=-1) {
            Table table = allTables.get(index);
            double price= table.getOrdersTotalPrice();
            price= price/split;
            price= Math.round(price * 100.0) / 100.0;
            table.clearOrders();
            return price;
        } else {
            throw new InaccessibleObjectException();
        }
    }

    public static void setSeats(int seats){
        Table barTable= allTables.get(findTable(bar));
        barTable.setNumOfSeats(seats);
    }

    public static void setBar(int barIn){
        bar=barIn;
    }

    public static int getSeats(){
        Table barTable= allTables.get(findTable(bar));
        return barTable.getNumOfSeats();
    }

    public int getBar(){
        return bar;
    }

    public void seatAtBar(){
        Table barTable= allTables.get(findTable(bar));

        int currentSeats= barTable.getFilledSeats();
        if(currentSeats<barTable.getNumOfSeats()) {
            barTable.setNumOfSeatsFilled(currentSeats + 1);
        }
    }

    public int seeFilledSeats(){
        Table barTable= allTables.get(findTable(bar));
        return barTable.getFilledSeats();
    }

    public List<Order> getOrders(){
        Table barTable= allTables.get(findTable(bar));
        return barTable.orders;
    }

    public HashMap getMenu(){
        return barMenu.getMenuItemMap();
    }

    public boolean doesOrderExist(int orderNum){
        Table barTable= allTables.get(findTable(bar));
        if(barTable.findOrder(orderNum)==-1){
            return false;
        } else {
            return true;
        }
    }

    public int getNextOrderNum(){
        Table barTable= allTables.get(findTable(bar));
        List<Order> orders= barTable.orders;
        int newNumber= orders.size()+1;
        while(doesOrderExist(newNumber)){
            newNumber++;
        }
        return newNumber;
    }
}
