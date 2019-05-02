package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.Employee;
import edu.ithaca.comp345.Rockstar.Order;
import edu.ithaca.comp345.Rockstar.Table;
import edu.ithaca.comp345.Rockstar.waiterApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class WaiterUI implements ActionListener {
    public static final String ORDER = "Add to Order";
    public static final String CREATE = "Create Order";
    public static final String SEE = "View Table's Orders";

    public static final String PAY = "Pay Total Bill";
    public static final String SPLITOT = "Split Bill by Number";
    public static final String SPLITORD = "Split Bill by Order";

    public WaiterGui GUI;
    public waiterApi API;
    public List<Table> waitersTables;
    public Employee waiter;


    public WaiterUI(WaiterGui gui, waiterApi api, Employee waiter){
        GUI = gui;
        API = api;
        waitersTables= API.waiters.get(waiter);
        this.waiter=waiter;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        int order= GUI.orderSelected();
        int table= GUI.tableSelected();
        String item= GUI.menuItemSelected();
        String action= ev.getActionCommand();
            if (action == ORDER || action == CREATE) {
                ordering(action, table, order, item);
            } else if (action == SEE) {
                viewing(table);
            } else if (action == PAY || action == SPLITOT || action == SPLITORD) {
                paying(action, table);
            }
    }

    public void ordering(String action, int tableNum, int orderNum, String itemName){
        if (tableNum != -1) {
            if (action == ORDER) {
                if(orderNum==-1){
                    GUI.showMessage("Please choose and order to add to.");
                }
                else if (!addToOrderUI(orderNum, itemName, tableNum)) {
                    GUI.showMessage("That item does not exist");
                }
            } else if (action == CREATE) {
                int newOrderNum = orderNum;
                newOrderNum = API.getNextOrderNum(tableNum);
                if (!addToOrderUI(newOrderNum, itemName, tableNum)) {
                    GUI.showMessage("That item does not exist");
                }
            }
        }else {
            GUI.showMessage("Please choose a table");
        }
    }

    public boolean addToOrderUI(int orderNum, String item, int tableNum){
        if(item==null){
            return false;
        }
        try {
            if (!API.doesOrderExist(orderNum, tableNum)) {
                GUI.addToOrderList(orderNum);
            } else {
                GUI.showMessage(item + " added to order " + orderNum);
            }
            API.takeOrder(item, tableNum, orderNum);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public void viewing(int tableNum){
        if(tableNum!=-1) {
            List<Order> orders = API.getOrders(tableNum);
            GUI.viewOrders(tableNum);
            GUI.setOrderList(orders);
        } else {
            GUI.showMessage("Please choose a table");
        }
    }

    public void paying(String action, int tableNum){
        if(action== PAY){
            double amount= API.payTotalBill(tableNum);
            GUI.showMessage("You are owed: $"+amount);
            GUI.clearOrderList();
        } else if(action==SPLITORD){
            String message= API.splitBillByItemString(tableNum);
            GUI.showMessage(message);
            GUI.clearOrderList();
        } else if(action==SPLITOT){
            String amount= GUI.getAmount();
            try {
                int amount2=0;
                if(amount!=""){
                    amount2 = Integer.parseInt(amount);
                }
                double cost= API.splitBillByTotal(tableNum, amount2);
                GUI.showMessage("Each person owes: $"+cost);
                GUI.clearOrderList();
            } catch (Exception e) {
                GUI.showMessage("Something went wrong, please check that there are only numbers in the text field.");
            }
        }
    }

    public String[] getMenu(){
        HashMap gotten= API.getMenu();
        String list[]= new String[gotten.values().size()];
        Set items= gotten.keySet();
        Iterator itemsItr= items.iterator();
        int i=0;
        while(itemsItr.hasNext()){
            Object current= itemsItr.next();
            list[i]= current.toString();
            i++;
        }
        return list;
    }

    public List<Order> getOrders(int tableNum){
        if(API.findTable(tableNum)==-1){
            return null;
        }
        return API.getOrders(tableNum);
    }

    public List<Table> getTables(){return waitersTables;}

    public String getName(){return waiter.getName();}
}
