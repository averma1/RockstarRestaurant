package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.managerApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerController implements ActionListener {

    private ManagerView managerView;
    private managerApi managerAPI;
    private RestaurantView restaurantView;
    private String strPin;
    public static final String HOST= "Host";
    public static final String BARTENDER= "Bartender";
    public static final String WAITER= "Waiter";
    public static final String LOGOUT= "Logout";

    public ManagerController(ManagerView managerView, managerApi managerAPI, RestaurantView restaurantView, String strPin){
        this.managerView = managerView;
        this.managerAPI = managerAPI;
        this.restaurantView= restaurantView;
        this.strPin = strPin;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (HOST.equals(e.getActionCommand())){
            System.out.println("host");
           // System.exit(0);
            restaurantView.moveToHostView(strPin);
        }
        if (BARTENDER.equals(e.getActionCommand())){
            System.out.println("bartender");
           // System.exit(0);
            restaurantView.moveToBartenderView(strPin);
        }
        if (WAITER.equals(e.getActionCommand())){
            System.out.println("waiter");
           // System.exit(0);
            restaurantView.moveToWaiterView(strPin);
        }
        if(LOGOUT.equals(e.getActionCommand())){
            restaurantView.moveToLogin();
        }
    }

}
