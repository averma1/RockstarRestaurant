package edu.ithaca.comp345.Rockstar;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

public class waiterApi extends Restaurant{


    public static void takeOrder(MenuItem item, int tableNum, int orderNum){
        int index= findTable(tableNum);
        if(index!=-1) {
            Table table = allTables.get(index);
            if(table.findOrder(orderNum)==-1){
                table.createOrder(orderNum);
            }
            table.addtoOrder(item, orderNum);
        } else {
            throw new InaccessibleObjectException();
        }

    }

    public double payTotalBill(int tableNum){
        int index= findTable(tableNum);
        if(index!=-1) {
            Table table = allTables.get(index);
            return table.getOrdersTotalPrice();
        } else {
            throw new InaccessibleObjectException();
        }
    }

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

    public static List<Order> splitBillByItem(int tableNum){
        return null;
    }

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

