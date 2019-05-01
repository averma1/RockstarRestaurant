package edu.ithaca.comp345.Rockstar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HostUI implements ActionListener {

    public static final String SEAT = "Seat Customers";

    public HostGUI GUI;
    public hostApi API;

    public List<Table> mTables;

    public Employee host;

    public HostUI(HostGUI gui, hostApi api, Employee host){
        GUI = gui;
        API = api;
        this.host=host;
        mTables = API.allTables;
        System.out.println(API.allTables);
    }


    @Override
    public void actionPerformed(ActionEvent ev) {
        String action= ev.getActionCommand();
        int table= GUI.tableSelected();
        if (action == SEAT){
            seating(action, table);
        }
    }


    public void seating(String action, int tableNum){
//        String amount= GUI.getAmount();
        String amount= GUI.getAmount();
        if(action== SEAT){
            API.seatCustomers(tableNum, Integer.parseInt(amount));
            API.printTableData(tableNum);

//            try {
//                int amount2=0;
//                if(amount!=""){
//                    amount2 = Integer.parseInt(amount);
//                }
//                if(amount2<=API.getSeats(tableNum)) {
//                    API.seatAtTable(tableNum, amount2);
//                    GUI.showMessage(API.seeFilledSeats(tableNum)+" people seated at table "+tableNum);
//                } else {
//                    GUI.showMessage("That many people will not fit at this table");
//                }
//            } catch (Exception e) {
//                GUI.showMessage("Something went wrong, please check that there are only numbers in the text field.");
//            }
        }
//        else if(action==SEE){
//            GUI.viewOrders(tableNum);
//        }
    }

    public String getName(){return host.getName();}

    public List<Table> getTables(){

        System.out.println(API.allTables);

        return mTables;


    }

}
