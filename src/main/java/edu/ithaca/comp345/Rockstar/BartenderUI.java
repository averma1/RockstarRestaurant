package edu.ithaca.comp345.Rockstar;

import edu.ithaca.comp345.Rockstar.ui.RestaurantView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BartenderUI implements ActionListener {
    public static final String ORDER = "Add to Order";
    public static final String PAY = "Pay Order";
    public static final String SEAT = "Seat Customer";
    public static final String SEE = "View all orders";
    public static final String CREATE = "Create new Order";
    public static final String HELP = "Help";
    public static final String LOGOUT = "Logout";
    public static final String SPLITOT = "Split Bill by Number";

    public BartenderGui GUI;
    public BartenderApi API;
    public RestaurantView restaurantView;



    public BartenderUI(BartenderGui gui, BartenderApi api, RestaurantView restaurantView){
        GUI = gui;
        API = api;
        this.restaurantView = restaurantView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action= e.getActionCommand();
        String item= GUI.menuItemSelected();
        int order= GUI.orderSelected();

        if(action==SEE){
            viewing();
        } else if(action== CREATE || action==ORDER){
            ordering(action, order, item);
        } else if(action == LOGOUT){
            restaurantView.moveToLogin();
        } else if(action==SPLITOT){
            splitPay(order);
        } else if(action==HELP){
            help();
        }  else {
                if (order != -1 && item != null) {
                    makeChanges(action, order, item);
                } else if (order == -1 && item != null) {
                    createOderChange(action, order, item);
                } else {
                    seatChange(action);
                }
            }
        }

    public void splitPay(int orderNum) {
        String amount= GUI.getAmount();
        try {
            int amount2=0;
            if(amount!=""){
                amount2 = Integer.parseInt(amount);
            }
            double cost= API.splitBillByTotal(amount2);
            GUI.showMessage("Each person owes: $"+cost);
        } catch (Exception e) {
            GUI.showMessage("Something went wrong, please check that there are only numbers in the text field.");
        }
    }

    public void help() {

    }

    public void viewing(){
        List<Order> orders = API.getOrders();
        GUI.setOrderList(orders);
    }

    public void ordering(String action, int orderNum, String itemName){
        if (action == ORDER) {
            if(orderNum==-1){
                GUI.showMessage("Please choose and order to add to.");
            }
            else if (!addToOrderUI(orderNum, itemName)) {
                GUI.showMessage("That item does not exist");
            }
        } else if (action == CREATE) {
            int newOrderNum = orderNum;
            newOrderNum = API.getNextOrderNum();
            if (!addToOrderUI(newOrderNum, itemName)) {
                GUI.showMessage("That item does not exist");
            }
        }
    }

    public void makeChanges(String actionCommand, int ordernum, String item){
        if(PAY.equals(actionCommand)){
            double price= payUI(ordernum);
            GUI.showMessage("order "+ordernum+" owes you $"+price);
        } else if(SEAT.equals(actionCommand)){
            seatPerson();
        }
        GUI.updateView();
    }

    public void seatChange(String actionCommand){
         if(SEAT.equals(actionCommand)){
            seatPerson();
        }
        GUI.updateView();
    }

    public void createOderChange(String actionCommand, int ordernum, String item){
        if(PAY.equals(actionCommand)){
            GUI.showMessage("You did not select an order to pay");
        } else if(SEAT.equals(actionCommand)){
            seatPerson();
        }
        GUI.updateView();
    }

    public boolean addToOrderUI(int orderNum, String item){
        try{
            if(!API.doesOrderExist(orderNum)){
                GUI.addToOrderList(orderNum);
            } else {
                GUI.showMessage(item+" added to order "+orderNum);
            }
            API.addToOrder(orderNum, item);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public double payUI(int orderNum){
        try{
            double payed= API.pay(orderNum);
            GUI.deleteFromOrderList(orderNum);
            return payed;
        } catch (IndexOutOfBoundsException e){
            return -1;
        }
    }

    public boolean seatPerson(){
        try{
            API.seatAtBar();
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public int getRemainingSeatsUI(){
        int amount= API.getSeats()- API.seeFilledSeats();
        if(amount>API.getSeats()){
            amount=API.getSeats();
        }
        return amount;
    }

    public boolean canSeat(){
        if(API.seeFilledSeats()+1>API.getSeats()){
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

    public List<Order> getOrders(){
        return API.getOrders();
    }
}
