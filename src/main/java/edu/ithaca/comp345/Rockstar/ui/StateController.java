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

        Employee current = restaurantView.managerAPI.employees.get(restaurantView.managerAPI.findEmployee(Integer.parseInt(strPin)));
        String mode1 = current.getType();
        UIMode mode = UIMode.valueOf(mode1);

        if (mode == UIMode.manager) {
            System.out.println("youre a manager!");
            restaurantView.moveToManagerView(strPin);
        } else if (mode == UIMode.host) {
            //call host UI
            System.out.println("youre a host!");
            restaurantView.moveToHostView(strPin);
        } else if (mode == UIMode.waiter) {
            //call waiter UI
            System.out.println("youre a waiter!");
            restaurantView.moveToWaiterView(strPin);
        } else if (mode == UIMode.bartender) {
            //call bartender UI
            System.out.println("youre a bartender!");
            restaurantView.moveToBartenderView(strPin);

        }
    }
}
