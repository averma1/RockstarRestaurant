package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.loginController;
import edu.ithaca.comp345.Rockstar.managerApi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {

    public String pin;
    public JTextField pinEnter;

    public LoginView(managerApi managerAPI, StateController stateController){

        LoginController loginController = new LoginController(this, managerAPI, stateController);
        /*
        JLabel pinLabel = new JLabel("Pin:");
        pinEntryBox = new JTextArea(1, 15);
        JButton loginButton = new JButton(LoginController.LOG_IN);
        loginButton.setActionCommand(LoginController.LOG_IN);
        loginButton.addActionListener(loginController);
        */
        this.setLayout(new FlowLayout());
        /*
        this.add(pinLabel);
        this.add(pinEntryBox);
        this.add(loginButton);
        */
        this.add(createPinEnterPanel());
        this.add(createKeypadPanel(loginController));
    }
    public JPanel createPinEnterPanel(){
        pin="Enter Pin";
        JPanel pinEnterPanel= new JPanel();
        pinEnter= new javax.swing.JTextField(pin);
        pinEnter.setEditable(false);
        pinEnterPanel.add(pinEnter);
        return pinEnterPanel;
    }
    public JPanel createKeypadPanel(ActionListener controller){
        JPanel keypad= new JPanel();
        JButton button;
        keypad.setLayout(new GridLayout(4,3));
        for (int i = 9; i >= 1; i--) {
            button = new JButton(Integer.toString(i));
            keypad.add(button);
            if(i==9){
                button.setActionCommand(LoginController.NINE);
            }
            if(i==8){
                button.setActionCommand(LoginController.EIGHT);
            }
            if(i==7){
                button.setActionCommand(LoginController.SEVEN);
            }
            if(i==6){
                button.setActionCommand(LoginController.SIX);
            }
            if(i==5){
                button.setActionCommand(LoginController.FIVE);
            }
            if(i==4){
                button.setActionCommand(LoginController.FOUR);
            }
            if(i==3){
                button.setActionCommand(LoginController.THREE);
            }
            if(i==2){
                button.setActionCommand(LoginController.TWO);
            }
            if(i==1){
                button.setActionCommand(LoginController.ONE);
            }

            button.addActionListener(controller);
        }

        //Adds the other three buttons
        //Backspace Button
        JButton backSpaceButton= new JButton("Delete");
        keypad.add(backSpaceButton);
        backSpaceButton.setActionCommand(loginController.BACKSPACE);
        backSpaceButton.addActionListener(controller);
        //0 button
        button=new JButton("0");
        keypad.add(button);
        button.setActionCommand(loginController.ZERO);
        button.addActionListener(controller);
        //Enter button
        JButton enterButton= new JButton("Enter");
        keypad.add(enterButton);
        enterButton.setActionCommand(loginController.ENTER);
        enterButton.addActionListener(controller);

        return keypad;
    }


    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
