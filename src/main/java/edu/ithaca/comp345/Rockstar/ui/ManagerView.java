package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.Employee;
import edu.ithaca.comp345.Rockstar.managerApi;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerView extends JPanel {
    private ManagerController managerController;
    private JLabel managerDisplay;
    private String strPin;
    private JButton logoutBtn;
    //Visual Objects go here

    public ManagerView(String strPin, managerApi managerAPI, RestaurantView restaurantView){
        this.managerController = new ManagerController(this, managerAPI, restaurantView, strPin);
        this.strPin = strPin;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createManagerDisplayPanel());
        this.add(createButtonPanel(managerController));

        }

    private JPanel createManagerDisplayPanel(){
        JPanel managerDisplayPanel = new JPanel();
        managerDisplayPanel.setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Manager View Panel: " + strPin);
        managerDisplayPanel.add(welcomeLabel);

        managerDisplay = new JLabel();
        managerDisplayPanel.add(managerDisplay);

        return managerDisplayPanel;
    }

    private JPanel createButtonPanel(ActionListener controller){

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        JButton hostButton= new JButton("Host");
        buttonPanel.add(hostButton);
        hostButton.setActionCommand(ManagerController.HOST);
        hostButton.addActionListener(controller);

        JButton bartenderButton= new JButton("Bartender");
        buttonPanel.add(bartenderButton);
        bartenderButton.setActionCommand(ManagerController.BARTENDER);
        bartenderButton.addActionListener(controller);

        JButton waiterButton= new JButton("Waiter");
        buttonPanel.add(waiterButton);
        waiterButton.setActionCommand(ManagerController.WAITER);
        waiterButton.addActionListener(controller);

        logoutBtn = new JButton("Logout");
        buttonPanel.add(logoutBtn);
        logoutBtn.setActionCommand(ManagerController.LOGOUT);
        logoutBtn.addActionListener(controller);
        return buttonPanel;
    }


}

