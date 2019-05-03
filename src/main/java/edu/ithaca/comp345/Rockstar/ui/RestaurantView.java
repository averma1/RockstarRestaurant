package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.*;

import javax.swing.*;

public class RestaurantView extends JPanel {


    managerApi managerAPI;
    BartenderApi bartenderAPI;
    waiterApi waiterAPI;
    hostApi hostAPI;
    RestaurantView restaurantView;
    Employee employee;


    public RestaurantView(Restaurant restaurant){
        this.managerAPI = restaurant.manager;
        bartenderAPI= restaurant.bartender;
        waiterAPI= restaurant.waiter;
        hostAPI= restaurant.host;
        StateController stateController = new StateController(this);
        this.add(new LoginView(managerAPI, stateController));
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void moveToBartenderView(String pin){
        this.removeAll();
        this.add(new BartenderGui(bartenderAPI));
        this.revalidate();
        this.repaint();
    }

    public void moveToManagerView(String pin){
        this.removeAll();
        this.add(new ManagerView(pin, managerAPI, restaurantView));
        this.revalidate();
        this.repaint();
    }

    public void moveToWaiterView(String pin){
        this.removeAll();
        this.add(new WaiterGui(waiterAPI, employee));
        this.revalidate();
        this.repaint();
    }

    public void moveToHostView(String pin){
        this.removeAll();
        this.add(new HostGUI(hostAPI,employee));
        this.revalidate();
        this.repaint();
    }
}
