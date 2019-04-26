package edu.ithaca.comp345.Rockstar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class BartenderUI implements ActionListener {
    public static final String ORDER = "Add to Order";
    public static final String PAY = "Pay Order";
    public static final String SEAT = "Seat Customer";

    public BartenderGui GUI;
    public BartenderApi API;


    public BartenderUI(BartenderGui gui, BartenderApi api){
        GUI = gui;
        API = api;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        makeChanges(e.getActionCommand());
    }

    public void makeChanges(String actionCommand){
        if(PAY.equals(actionCommand)){
            double price= payUI(1);
            if(price==-1){
                GUI.showMessage("That order does not exist");
            } else {

            }
        } else if(ORDER.equals(actionCommand)){
            if(!addToOrderUI(1, "mojito")){
               GUI.showMessage("That item does not exist");
            }
        } else if(SEAT.equals(actionCommand)){
            seatPerson();
        }

        GUI.updateView();
    }

    public boolean addToOrderUI(int orderNum, String item){
        try{
            API.addToOrder(orderNum, item);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public double payUI(int orderNum){
        double payed= API.pay(orderNum);
        return payed;
//        try{
//            double payed= API.pay(orderNum);
//            return payed;
//        } catch (IndexOutOfBoundsException e){
//            return -1;
//        }
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
        return API.getSeats()- API.seeFilledSeats();
    }

    public boolean canSeat(){
        if(API.seeFilledSeats()+1>API.getSeats()){
            return false;
        } else {
            return true;
        }
    }

    public HashMap<String, MenuItem> getMenu(){
        return API.barMenu.getMenuItemMap();
    }

    public List<Order> getOrders(){
        return API.getOrders();
    }
}
