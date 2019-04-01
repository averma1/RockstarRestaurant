package edu.ithaca.comp345.Rockstar;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

public class waiterApi {

    public static hostApi tableAccess= new hostApi();

    public static void takeOrder(MenuItem item, int tebleNum, int orderNum){

    }

    public double payTotalBill(int tableNum){
        return 0;
    }

    public static double splitBillByTotal(int tableNum, int split){
        return 0;
    }

    public static List<Order> splitBillByItem(int tableNum){
        return null;
    }

    public static Order viewOrder(int tableNum, int orderNum){
        int index= tableAccess.findTable(tableNum);
        if(index!=-1) {
            Table table = tableAccess.allTables.get(index);
            return table.getOrder(orderNum);
        } else {
            throw new InaccessibleObjectException();
        }
    }

    public static List<Order> viewTableOrders(int tableNum){
        int index= tableAccess.findTable(tableNum);
        if(index!=-1) {
            Table table = tableAccess.allTables.get(index);
            return table.getAllOrders();
        } else {
            throw new InaccessibleObjectException();
        }
    }
}

