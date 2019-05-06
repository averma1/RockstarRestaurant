package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.ManagerApi;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ManagerView extends JPanel {
    private ManagerController managerController;
    private JLabel managerDisplay;
    private String strPin;
    private JButton logoutBtn;
    private Font font;
    private Font managerFont;
    //Visual Objects go here

    public ManagerView(String strPin, ManagerApi managerAPI, RestaurantView restaurantView){
        this.managerController = new ManagerController(this, managerAPI, restaurantView, strPin);
        this.strPin = strPin;
        this.font= new Font("Verdana", Font.PLAIN, 20);
        this.managerFont= new Font("Crystal",Font.BOLD, 25);

        this.setLayout(new BorderLayout());
        this.add(createManagerDisplayPanel(),BorderLayout.NORTH);
        this.add(createButtonPanel(managerController),BorderLayout.SOUTH);

        }

    private JPanel createManagerDisplayPanel(){
        JPanel managerDisplayPanel = new JPanel();

        JTextField managerMsg = new JTextField("Manager View Panel: " + strPin);
        managerMsg.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        managerDisplayPanel.add(managerMsg);
        managerMsg.setFont(managerFont);
        managerMsg.setOpaque(false);

        return managerDisplayPanel;
    }

    private JPanel createButtonPanel(ActionListener controller){

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        JButton hostButton= new JButton("Host");
        hostButton.setPreferredSize(new Dimension(100,100));
        hostButton.setFont(font);
        buttonPanel.add(hostButton);
        hostButton.setActionCommand(ManagerController.HOST);
        hostButton.addActionListener(controller);

        JButton bartenderButton= new JButton("Bartender");
        bartenderButton.setPreferredSize(new Dimension(100,100));
        bartenderButton.setFont(font);
        buttonPanel.add(bartenderButton);
        bartenderButton.setActionCommand(ManagerController.BARTENDER);
        bartenderButton.addActionListener(controller);

        JButton waiterButton= new JButton("Waiter");
        waiterButton.setPreferredSize(new Dimension(100,100));
        waiterButton.setFont(font);
        buttonPanel.add(waiterButton);
        waiterButton.setActionCommand(ManagerController.WAITER);
        waiterButton.addActionListener(controller);

        logoutBtn = new JButton("Logout");
        logoutBtn.setPreferredSize(new Dimension(100,100));
        logoutBtn.setFont(font);
        buttonPanel.add(logoutBtn);
        logoutBtn.setActionCommand(ManagerController.LOGOUT);
        logoutBtn.addActionListener(controller);
        return buttonPanel;
    }


}

