package edu.ithaca.comp345.Rockstar;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class waiterApi extends Restaurant{

    public HashMap<Employee, List<Table>> waiters;

    /**
     * takes the order and adds to list of orders
     * @param item: the menuitem
     * @param tableNum: the table number
     * @param orderNum: the order number
     */
    public static void takeOrder(MenuItem item, int tableNum, int orderNum){
        int index= findTable(tableNum);
        if(index!=-1) {
            Table table = allTables.get(index);
            if(table.findOrder(orderNum)==-1){
                table.createOrder(orderNum);
            }
            if(stock!=null) {
                stock.removeMenuItem(item);
            }
            table.addtoOrder(item, orderNum);
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
            return table.getOrdersTotalPrice();
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
            return table.orders;
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


}

