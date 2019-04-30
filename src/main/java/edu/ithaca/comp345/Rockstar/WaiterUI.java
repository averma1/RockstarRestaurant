package edu.ithaca.comp345.Rockstar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class WaiterUI implements ActionListener {
    public static final String ORDER = "Add to Order";
    public static final String PAY = "Pay Order";
    public static final String SEAT = "Seat Customer";

    public WaiterGui GUI;
    public waiterApi API;
    public List<Table> waitersTables;


    public WaiterUI(WaiterGui gui, waiterApi api, int waiterPin){
        GUI = gui;
        API = api;
        waitersTables= API.waiters.get(waiterPin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int order= GUI.orderSelected();
        int table= GUI.tableSelected();
        String item= GUI.menuItemSelected();
        if(GUI.orderSelected()!=-1 && GUI.menuItemSelected()!=null) {
            makeChanges(e.getActionCommand(), order, item, table, 0);
        } else if(GUI.orderSelected()==-1 && GUI.menuItemSelected()!=null){
            createOderChange(e.getActionCommand(), order, item, table, 0);
        } else {
            seatChange(e.getActionCommand(), table, 0);
        }
    }

    public void makeChanges(String actionCommand, int ordernum, String item, int table, int numOfPeople){
        if(PAY.equals(actionCommand)){
            double price= payUI(ordernum);
            GUI.showMessage("order "+ordernum+" owes you $"+price);
        } else if(ORDER.equals(actionCommand)){
            if(!addToOrderUI(ordernum, item, table)){
                GUI.showMessage("That item does not exist");
            }
        } else if(SEAT.equals(actionCommand)){
            seatPerson(table, numOfPeople);
        }
        GUI.updateView();
    }

    public void seatChange(String actionCommand, int table, int numOfPeople){
        if(SEAT.equals(actionCommand)){
            seatPerson(table, numOfPeople);
        }
        GUI.updateView();
    }

    public void createOderChange(String actionCommand, int ordernum, String item, int tableNum, int numOfPeople){
        if(PAY.equals(actionCommand)){
            GUI.showMessage("You did not select an order to pay");
        } else if(ORDER.equals(actionCommand)){
            int newOrderNum= API.getNextOrderNum(tableNum);
            if(!addToOrderUI(newOrderNum, item, tableNum)){
                GUI.showMessage("That item does not exist");
            }
        } else if(SEAT.equals(actionCommand)){
            seatPerson(tableNum, numOfPeople);
        }
        GUI.updateView();
    }

    public boolean addToOrderUI(int orderNum, String item, int tableNum){
        try{
            if(!API.doesOrderExist(orderNum, tableNum)){
                GUI.addToOrderList(orderNum);
            } else {
                GUI.showMessage(item+" added to order "+orderNum);
            }
            API.takeOrder(item, tableNum, orderNum);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public double payUI(int tableNum){
        try{
            double payed= API.payTotalBill(tableNum);
            GUI.deleteFromTableList(tableNum);
            return payed;
        } catch (IndexOutOfBoundsException e){
            return -1;
        }
    }

    public boolean seatPerson(int tableNum, int numberOfPeople){
        try{
            API.seatAtTable(tableNum, numberOfPeople);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public int getRemainingSeatsUI(int tableNum){
        if(API.findTable(tableNum)==-1){
            return 0;
        } else {
            return API.getSeats(tableNum) - API.seeFilledSeats(tableNum);
        }
    }

    public boolean canSeat(int tableNum){
        if(API.findTable(tableNum)==-1){
            return false;
        }
        if(API.seeFilledSeats(tableNum)+1>API.getSeats(tableNum)){
            return false;
        } else {
            return true;
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

    public Integer[] getOrdersList(int tableNum){
        if(API.findTable(tableNum)==-1){
            return null;
        }
        List<Order> gotten= API.getOrders(tableNum);
        Integer list[]= new Integer[gotten.size()];
        for(int i=0; i<gotten.size(); i++){
            list[i]=gotten.get(i).number;
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
}
