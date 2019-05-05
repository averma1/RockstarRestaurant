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
    public static final String HELP = "Help";
    public static final String BACK = "Logout";

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
            } else if(action==HELP){
                help();
            } else if(action==BACK){
                logout();
            }
    }

    public void help() {
        String message="";
        message+="Help Button: \n \t shows you what each aspect of the page does\n";
        message+="Logout Button: \n \t closes your current view and takes you back to enter a new pin\n";
        message+="Current User: \n \t displays the name of the person you are logged in as\n";
        message+="Create Order Button: \n \t generates a new number for a brand new order, if an item is selected it will be added, must first select a table\n";
        message+="View Tables's Orders Button: \n \t prints all the items in each order and their price at the bottom of the page, must first select a table\n";
        message+="Add to Order Button: \n \t adds selected item to selected order, must select an item, must select an order\n";
        message+="Menu Panel: \n \t displays all the items in the menu that are available\n";
        message+="Table Panel: \n \t displays all the tables assigned to the logged in waiter\n";
        message+="Order Panel: \n \t displays all the orders of the table you have selected\n";
        message+="Order Items: \n \t all the items in each order and their price, displayed by view table's orders button\n";
        message+="Pay Total Bill Button: \n \t gives you the total cost of all the orders in selected table, must select a table, will delete all orders in that table\n";
        message+="Split Bill by Number Button: \n \t gives you the amount each person must pay when the total cost is divided by the entered number, must enter a number, must select a table\n";
        message+="Split Bill by Order Button: \n \t gives you the total cost each order must pay from the given table, must select a table\n";
        GUI.showMessage(message);
    }

    public void logout() {

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
