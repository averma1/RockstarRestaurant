package edu.ithaca.comp345.Rockstar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class loginGui extends JPanel {
    int width=JFrame.MAXIMIZED_HORIZ;
    int height=JFrame.MAXIMIZED_VERT;
    public loginGui(){
        loginController listener= new loginController(this);
    }
    public static void main(String[] args) {
        JButton button;
        JPanel welcomePanel= new JPanel();
        JPanel wrapper= new JPanel();
        JPanel topBox= new JPanel();
        JPanel pinEnterPanel= new JPanel();

        ButtonHandler listener=new ButtonHandler();
        JTextField pinEnter= new javax.swing.JTextField("Enter Pin");
        pinEnter.setEditable(false);

        wrapper.setLayout(new BoxLayout(wrapper,BoxLayout.PAGE_AXIS));

        JPanel keypad= new JPanel();
        keypad.setLayout(new GridLayout(4,3));
        for (int i = 9; i >= 1; i--) {
            button = new JButton(Integer.toString(i));
            keypad.add(button);
            if(i==9){
                button.setActionCommand(loginController.NINE);
            }
            if(i==8){
                button.setActionCommand(loginController.EIGHT);
            }
            if(i==7){
                button.setActionCommand(loginController.SEVEN);
            }
            if(i==6){
                button.setActionCommand(loginController.SIX);
            }
            if(i==5){
                button.setActionCommand(loginController.FIVE);
            }
            if(i==4){
                button.setActionCommand(loginController.FOUR);
            }
            if(i==3){
                button.setActionCommand(loginController.THREE);
            }
            if(i==2){
                button.setActionCommand(loginController.TWO);
            }
            if(i==1){
                button.setActionCommand(loginController.ONE);
            }

            button.addActionListener(listener);
        }

        //Adds the other three buttons
        //Backspace Button
        JButton backSpaceButton= new JButton("Delete");
        keypad.add(backSpaceButton);
        backSpaceButton.setActionCommand(loginController.BACKSPACE);
        backSpaceButton.addActionListener(listener);
        //0 button
        button=new JButton("0");
        keypad.add(button);
        button.setActionCommand(loginController.ZERO);
        button.addActionListener(listener);
        //Enter button
        JButton enterButton= new JButton("Enter");
        keypad.add(enterButton);
        enterButton.setActionCommand(loginController.ENTER);
        enterButton.addActionListener(listener);
        //Adds keypad to its own panel
        //keypadPanel.add(keypad);


        pinEnterPanel.add(pinEnter);
        topBox.add(pinEnterPanel);
        wrapper.add(topBox);




        wrapper.add(keypad);
        //Sets window specs
        JFrame window = new JFrame("System Login");
        window.setContentPane(wrapper);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);



    }


}
