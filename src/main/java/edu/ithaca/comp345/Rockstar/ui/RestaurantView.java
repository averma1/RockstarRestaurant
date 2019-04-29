package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.BartenderApi;
import edu.ithaca.comp345.Rockstar.hostApi;
import edu.ithaca.comp345.Rockstar.managerApi;
import edu.ithaca.comp345.Rockstar.waiterApi;

import javax.swing.*;

public class RestaurantView extends JPanel {


    managerApi managerAPI;
    BartenderApi bartenderAPI;
    waiterApi waiterAPI;
    hostApi hostAPI;
    RestaurantView restaurantView;


    public RestaurantView(managerApi managerAPI){
        this.managerAPI = managerAPI;
        StateController stateController = new StateController(this);
        this.add(new LoginView(managerAPI, stateController));
    }

    public void moveToBartenderView(String pin){
        //TODO get bartender stuff in order
//        this.removeAll();
//        this.add(new BartenderView(pin, bartenderAPI));
//        this.revalidate();
//        this.repaint();
    }

    public void moveToManagerView(String pin){
        this.removeAll();
        this.add(new ManagerView(pin, managerAPI, restaurantView));
        this.revalidate();
        this.repaint();
    }

    public void moveToWaiterView(String pin){
        //TODO connect this w waiter gui
     /*   this.removeAll();
        this.add(new WaiterView(pin, waiterAPI));
        this.revalidate();
        this.repaint();*/
    }

    public void moveToHostView(String pin){
        //TODO connect this w host gui
      /*  this.removeAll();
        this.add(new HostView(pin, hostAPI));
        this.revalidate();
        this.repaint();*/
    }
}
