package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.managerApi;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerView extends JPanel {
    private ManagerController controller;
    private JLabel managerDisplay;
    private String strPin;

    //Visual Objects go here

    public ManagerView(String strPin, managerApi managerAPI){
        this.controller = new ManagerController(this, managerAPI, strPin);
        this.strPin = strPin;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createManagerDisplayPanel());
        this.add(createActionPanel(controller));

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

    private JPanel createActionPanel(ActionListener controller){

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());

        return actionPanel;
    }


}

