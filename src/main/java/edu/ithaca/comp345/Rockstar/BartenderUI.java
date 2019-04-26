package edu.ithaca.comp345.Rockstar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BartenderUI implements ActionListener {
    public static final String ORDER = "order";
    public static final String PAY = "pay";
    public static final String SEAT = "seat";

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

        } else if(ORDER.equals(actionCommand)){

        } else if(SEAT.equals(actionCommand)){
            seatPerson(1);
        }

    }

    public boolean addToOrderUI(int orderNum, MenuItem item){
        try{
            API.addToOrder(orderNum, item);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public double payUI(int orderNum){
        try{
            double payed= API.pay(orderNum);
            return payed;
        } catch (IndexOutOfBoundsException e){
            return -1;
        }
    }

    public boolean seatPerson(int numOfPeople){
        try{
            API.seatAtBar(numOfPeople);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public int getRemainingSeatsUI(){
        return API.getSeats()- API.seeFilledSeats();
    }
}
