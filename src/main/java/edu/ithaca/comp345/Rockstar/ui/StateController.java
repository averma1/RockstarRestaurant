package edu.ithaca.comp345.Rockstar.ui;


import edu.ithaca.comp345.Rockstar.Employee;
import edu.ithaca.comp345.Rockstar.UIMode;

public class StateController {
    public RestaurantView restaurantView;

    public StateController(RestaurantView restaurantView) {
        this.restaurantView = restaurantView;
    }

    public void login(String strPin) { //TODO should this be an int?
        System.out.println("logging you in!");
        int pin= Integer.parseInt(strPin);
        int index=restaurantView.managerAPI.findEmployee(pin);

        Employee current = restaurantView.managerAPI.employees.get(index);
        restaurantView.setEmployee(current);
        String mode1 = current.getType();
        UIMode mode = UIMode.valueOf(mode1);

        if (mode == UIMode.manager) {
            System.out.println("you're a manager!");
            restaurantView.moveToManagerView(strPin);
        } else if (mode == UIMode.host) {
            //call host UI
            System.out.println("you're a host!");
            restaurantView.moveToHostView(strPin);
        } else if (mode == UIMode.waiter) {
            //call waiter UI
            System.out.println("you're a waiter!");
            restaurantView.moveToWaiterView(strPin);
        } else if (mode == UIMode.bartender) {
            //call bartender UI
            System.out.println("you're a bartender!");
            restaurantView.moveToBartenderView(strPin);

        }
    }
}
