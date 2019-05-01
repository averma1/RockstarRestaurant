package edu.ithaca.comp345.Rockstar;

import java.lang.reflect.InaccessibleObjectException;
import java.util.HashMap;
import java.util.List;

public class waiterApi extends Restaurant{
    /**
     * takes the order and adds to list of orders
     * @param item: the menuitem
     * @param tableNum: the table number
     * @param orderNum: the order number
     */
    public static void takeOrder(String item, int tableNum, int orderNum){
        MenuItem Item= Menu.getMenuItem(item);
        int index= findTable(tableNum);
        if(index!=-1) {
            Table table = allTables.get(index);
            if(table.findOrder(orderNum)==-1){
                table.createOrder(orderNum);
            }
            if(stock!=null) {
                stock.removeMenuItem(Item);
            }
            table.addtoOrder(Item, orderNum);
        } else {
            throw new InaccessibleObjectException();
        }

    }
    /**
     * returns the total price of the table (all orders)
     * @param tableNum: table number
     * @return get total price of the table
     */
    public double payTotalBill(int tableNum){
        int index= findTable(tableNum);
        if(index!=-1) {
            Table table = allTables.get(index);
            double amount =table.getOrdersTotalPrice();
            table.clearOrders();
            return amount;
        } else {
            throw new InaccessibleObjectException();
        }
    }
    /**
     * splits the bill by a given number
     * @param tableNum: table number
     * @param split:
     * @return
     */
    public static double splitBillByTotal(int tableNum, int split){
        int index= findTable(tableNum);
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
    /**
     * splits the bill by item
     * @param tableNum
     * @return list of total orders in the table
     */
    public static List<Order> splitBillByItem(int tableNum){
        int index = findTable(tableNum);
        if(index != -1){
            Table table = allTables.get(index);
            List<Order> orders= table.orders;
            return orders;
        } else{
            throw new InaccessibleObjectException();
        }
    }

    public static String splitBillByItemString(int tableNum){
        int index = findTable(tableNum);
        if(index != -1){
            Table table = allTables.get(index);
            List<Order> orders= table.orders;
            String message= "";
            for(int i=0; i<orders.size(); i++){
                message=message+"Order #"+orders.get(i).number+" owes $"+orders.get(i).getTotalPrice()+"\n";
            }
            table.clearOrders();
            return message;
        } else{
            throw new InaccessibleObjectException();
        }
    }
    /**
     * returns a list of items in the order
     * @param tableNum: table number
     * @param orderNum: order number
     * @return: list of items in the order
     */
    public static List<MenuItem> viewOrder(int tableNum, int orderNum){
        int index= findTable(tableNum);
        if(index!=-1) {
            Table table = allTables.get(index);
            Order items= table.getOrder(orderNum);
            if(items!=null){
                return items.items;
            }
        }
        throw new InaccessibleObjectException();
    }

    public static List<Table> getWaitersTables(int pin, String name){
        int index= managerApi.findEmployee(pin);
        if(index==-1){
            throw new InaccessibleObjectException();
        } else {
            Employee waiter= employees.get(index);
            if(waiter.getType()!="waiter"){
                throw new InaccessibleObjectException();
            } else {
                return waiters.get(waiter);
            }
        }
    }

    public List<Order> getOrders(int tableNum){
        Table barTable= allTables.get(findTable(tableNum));
        return barTable.orders;
    }

    public HashMap getMenu(){
        return Menu.getMenuItemMap();
    }

    public boolean doesOrderExist(int orderNum, int tablenum){
        Table barTable= allTables.get(findTable(tablenum));
        if(barTable.findOrder(orderNum)==-1){
            return false;
        } else {
            return true;
        }
    }

    public int getNextOrderNum(int tableNum){
        Table barTable= allTables.get(findTable(tableNum  ));
        List<Order> orders= barTable.orders;
        int newNumber= orders.size()+1;
        while(doesOrderExist(newNumber, tableNum)){
            newNumber++;
        }
        return newNumber;
    }
    public void seatAtTable(int tableNum, int numberOfPeople){
        Table barTable= allTables.get(findTable(tableNum));
        barTable.setNumOfSeatsFilled(numberOfPeople);
    }
    public static int getSeats(int tableNum){
        Table barTable= allTables.get(findTable(tableNum));
        return barTable.getNumOfSeats();
    }
    public int seeFilledSeats(int tableNum){
        Table barTable= allTables.get(findTable(tableNum));
        return barTable.getFilledSeats();
    }
}

