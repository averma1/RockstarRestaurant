package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.Restaurant;
import edu.ithaca.comp345.Rockstar.SwingTestUtil;

import java.io.IOException;

public class AccountViewTest {
    public static void main(String[] args) throws Exception {
        Restaurant testRest = new Restaurant("The best restaurant around!");
        testRest.loadPinsFromFile("PinTestInputFile.txt");
        testRest.manager.addEmployee(3344, "Tony", "manager");

        RestaurantView restaurantView = new RestaurantView(testRest.manager);
        //StateController stateController = new StateController(restaurantView);
        SwingTestUtil.showPanelInTestFrame(restaurantView);
    }
}
