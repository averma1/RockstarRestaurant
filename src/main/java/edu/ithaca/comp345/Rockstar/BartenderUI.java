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
    public static final String SPLITOT = "Split Order by Number";

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
            try{
                ordering(action, order, item);
            } catch(IllegalArgumentException ee){
                GUI.showMessage("Please select an Item to Order");
            }

        } else if(action == LOGOUT){
            restaurantView.moveToLogin();
        } else if(action==SPLITOT){
            splitPay(order);
        } else if(action==HELP){
            help();
        } else {
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
        String message="";
        message+="Help Button: \n \t shows you what each aspect of the page does\n";
        message+="Logout Button: \n \t closes your current view and takes you back to enter a new pin\n";
        message+="Seat Customer Button: \n \t decrements the available seats by one\n";
        message+="Amount of Seats: \n \t displays the current number of chairs still open at the bar\n";
        message+="Create new Order Button: \n \t generates a new number for a brand new order, if an item is selected it will be added\n";
        message+="Add to Order Button: \n \t adds selected item to selected order, must select an item, must select an order\n";
        message+="View All Orders Button: \n \t prints all the items in each order and their price at the bottom of the page\n";
        message+="Orders Panel: \n \t displays all the orders at the bar\n";
        message+="Menu Panel: \n \t displays all the items in the menu that are available\n";
        message+="Order Items: \n \t all the items in each order and their price, displayed by view all orders button\n";
        message+="Pay Order Button: \n \t gives you the total cost of all the orders, must select an order, that order will be deletes, available seats will be incremented by one\n";
        message+="Split Order by Number Button: \n \t gives you the amount each person must pay when the total cost is divided by the entered number, must enter a number, must select an order\n";
        GUI.showMessage(message);
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
