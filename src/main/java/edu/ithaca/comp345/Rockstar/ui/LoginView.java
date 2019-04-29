package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.managerApi;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {

    private JTextArea pinEntryBox;

    public LoginView(managerApi managerAPI, StateController stateController){

        LoginController loginController = new LoginController(this, managerAPI, stateController);

        JLabel pinLabel = new JLabel("Pin:");
        pinEntryBox = new JTextArea(1, 15);
        JButton loginButton = new JButton(LoginController.LOG_IN);
        loginButton.setActionCommand(LoginController.LOG_IN);
        loginButton.addActionListener(loginController);

        this.setLayout(new FlowLayout());
        this.add(pinLabel);
        this.add(pinEntryBox);
        this.add(loginButton);
    }

    public String getPinEntered(){
        return pinEntryBox.getText();
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
