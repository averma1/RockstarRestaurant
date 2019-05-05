package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.*;

import javax.swing.*;

public class RestaurantView extends JPanel {


    managerApi managerAPI;
    BartenderApi bartenderAPI;
    waiterApi waiterAPI;
    hostApi hostAPI;
    Employee employee;
    StateController stateController;


    public RestaurantView(Restaurant restaurant){
        this.managerAPI = restaurant.manager;
        bartenderAPI= restaurant.bartender;
        waiterAPI= restaurant.waiter;
        hostAPI= restaurant.host;
        this.stateController = new StateController(this);
        this.add(new LoginView(managerAPI, stateController));
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void moveToBartenderView(String pin){
        this.removeAll();
        this.add(new BartenderGui(bartenderAPI, this));
        this.revalidate();
        this.repaint();
    }

    public void moveToManagerView(String pin){
        this.removeAll();
        this.add(new ManagerView(pin, managerAPI, this));
        this.revalidate();
        this.repaint();
    }

    public void moveToWaiterView(String pin){
        this.removeAll();
        this.add(new WaiterGui(waiterAPI, employee, this));
        this.revalidate();
        this.repaint();
    }

    public void moveToHostView(String pin){
        this.removeAll();
        this.add(new HostGUI(hostAPI,employee, this));
        this.revalidate();
        this.repaint();
    }

    public void moveToLogin(){
        this.removeAll();
        this.add(new LoginView(managerAPI, stateController));
        this.revalidate();
        this.repaint();
    }
}
