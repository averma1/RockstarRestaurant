package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.Employee;
import edu.ithaca.comp345.Rockstar.Restaurant;
import edu.ithaca.comp345.Rockstar.Table;
import edu.ithaca.comp345.Rockstar.hostApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HostUI implements ActionListener {

    public static final String SEAT = "Seat Customers";
    public static final String LOGOUT = "Logout";

    public HostGUI GUI;
    public hostApi API;
    public RestaurantView restView;

    public List<Table> mTables;

    public Employee host;

    public HostUI(HostGUI gui, hostApi api, Employee host, RestaurantView restaurantView){
        GUI = gui;
        API = api;
        this.host=host;
        mTables = API.allTables;
        this.restView = restaurantView;

    }


    @Override
    public void actionPerformed(ActionEvent ev) {
        String action= ev.getActionCommand();
        int table= GUI.tableSelected();
        if (action == SEAT){
            seating(action, table);
        }
        if(action == LOGOUT){
            restView.moveToLogin();
        }
    }


    public void seating(String action, int tableNum){
        String amount= GUI.getAmount();
        if(action== SEAT){
            try{
                API.seatCustomers(tableNum, Integer.parseInt(amount));
                GUI.updateFilledTables();
            }
            catch (Exception e){
                GUI.showMessage("This tables has already been seated");
            }
        }
    }

    public String getName(){return host.getName();}

    public List<Table> getTables(){ return mTables; }

}
