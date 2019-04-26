package edu.ithaca.comp345.Rockstar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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
                GUI.showMessage("You are owed $"+price);
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
            if(!API.doesOrderExist(orderNum)){
                GUI.addToOrderList(orderNum);
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
        return API.getSeats()- API.seeFilledSeats();
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

    public Integer[] getOrdersList(){
        List<Order> gotten= API.getOrders();
        Integer list[]= new Integer[gotten.size()];
        for(int i=0; i<gotten.size(); i++){
            list[i]=gotten.get(i).number;
        }
        return list;
    }

    public List<Order> getOrders(){
        return API.getOrders();
    }
}
