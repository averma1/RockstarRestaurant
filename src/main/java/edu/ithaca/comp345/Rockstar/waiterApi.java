package edu.ithaca.comp345.Rockstar;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;

public class waiterApi {

    public static hostApi tableAccess;

    public waiterApi(){
        tableAccess= new hostApi();
    }

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

    public static List<MenuItem> viewOrder(int tableNum, int orderNum){
        int index= tableAccess.findTable(tableNum);
        if(index!=-1) {
            Table table = tableAccess.allTables.get(index);
            Order items= table.getOrder(orderNum);
            if(items!=null){
                return items.items;
            }
        }
        throw new InaccessibleObjectException();
    }

}

