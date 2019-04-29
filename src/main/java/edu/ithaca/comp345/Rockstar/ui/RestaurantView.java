package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.bartenderApi;
import edu.ithaca.comp345.Rockstar.managerApi;

import javax.swing.*;

public class RestaurantView extends JPanel {


    managerApi managerAPI;
    bartenderApi bartenderAPI;

    public RestaurantView(managerApi managerAPI){
        this.managerAPI = managerAPI;
        StateController stateController = new StateController(this);
        this.add(new LoginView(managerAPI, stateController));
    }

    public void moveToBartenderView(String pin){
        //TODO
//        this.removeAll();
//        this.add(new BartenderView(pin, bartenderAPI));
//        this.revalidate();
//        this.repaint();
    }

    public void moveToManagerView(String pin){
        this.removeAll();
        this.add(new ManagerView(pin, managerAPI));
        this.revalidate();
        this.repaint();
    }
}
