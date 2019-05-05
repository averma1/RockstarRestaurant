package edu.ithaca.comp345.Rockstar.ui;

//import edu.ithaca.comp345.Rockstar.loginController;
import edu.ithaca.comp345.Rockstar.managerApi;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {

    public String pin;
    public JTextField pinEnter;
    private Font font;
    private Font welcomeFont;

    public LoginView(managerApi managerAPI, StateController stateController){

        LoginController loginController = new LoginController(this, managerAPI, stateController);
        this.font= new Font("Verdana", Font.PLAIN, 20);
        this.welcomeFont= new Font("Crystal",Font.BOLD, 25);

        this.setLayout(new BorderLayout());

        this.add(createTopPanel(),BorderLayout.NORTH);
        this.add(createPinEnterPanel(),BorderLayout.CENTER);
        this.add(createKeypadPanel(loginController),BorderLayout.SOUTH);
    }
    public JPanel createTopPanel(){
        JPanel topPanel= new JPanel();
        JTextArea message= new javax.swing.JTextArea("Welcome to the Rockstar Restaurant!\nLogin with PIN");
        message.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        topPanel.add(message);
        message.setFont(welcomeFont);
        message.setOpaque(false);
        return topPanel;
    }
    public JPanel createPinEnterPanel(){
        pin="Enter Pin";
        JPanel pinEnterPanel= new JPanel();
        pinEnter= new javax.swing.JTextField(pin);
        pinEnter.setEditable(false);
        pinEnterPanel.add(pinEnter);
        pinEnter.setPreferredSize(new Dimension(300,100));
        pinEnter.setHorizontalAlignment(JTextField.CENTER);
        pinEnter.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        pinEnter.setFont(font);
        return pinEnterPanel;
    }
    public JPanel createKeypadPanel(ActionListener controller){
        JPanel keypad= new JPanel();
        JButton button;
        keypad.setLayout(new GridLayout(4,3));
        for (int i = 9; i >= 1; i--) {
            button = new JButton(Integer.toString(i));
            button.setPreferredSize(new Dimension(100,100));
            button.setFont(font);
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
        backSpaceButton.setFont(font);
        keypad.add(backSpaceButton);
        backSpaceButton.setActionCommand(LoginController.BACKSPACE);
        backSpaceButton.addActionListener(controller);

        //0 button
        button=new JButton("0");
        button.setFont(font);
        keypad.add(button);
        button.setActionCommand(LoginController.ZERO);
        button.addActionListener(controller);

        //Enter button
        JButton enterButton= new JButton("Enter");
        enterButton.setFont(font);
        keypad.add(enterButton);
        enterButton.setActionCommand(LoginController.ENTER);
        enterButton.addActionListener(controller);

        return keypad;
    }


    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
