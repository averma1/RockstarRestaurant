package edu.ithaca.comp345.Rockstar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginController implements ActionListener {
    public static final String ZERO="0";
    public static final String ONE="1";
    public static final String TWO="2";
    public static final String THREE="3";
    public static final String FOUR="4";
    public static final String FIVE="5";
    public static final String SIX="6";
    public static final String SEVEN="7";
    public static final String EIGHT="8";
    public static final String NINE="9";
    public static final String BACKSPACE="Delete";
    public static final String ENTER="Enter";
    public String pinString="";
    public loginGui loginGui;
    public loginController(loginGui loginGui) {
        this.loginGui= loginGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ZERO.equals(e.getActionCommand())){
            addToPin(ZERO);
        }
        if (ONE.equals(e.getActionCommand())){
            addToPin(ONE);
        }
        if (TWO.equals(e.getActionCommand())){
            addToPin(TWO);
        }
        if (THREE.equals(e.getActionCommand())){
            addToPin(THREE);
        }
        if (FOUR.equals(e.getActionCommand())){
            addToPin(FOUR);
        }
        if (FIVE.equals(e.getActionCommand())){
            addToPin(FIVE);
        }
        if (SIX.equals(e.getActionCommand())){
            addToPin(SIX);
        }
        if (SEVEN.equals(e.getActionCommand())){
            addToPin(SEVEN);
        }
        if (EIGHT.equals(e.getActionCommand())){
            addToPin(EIGHT);
        }
        if (NINE.equals(e.getActionCommand())){
            addToPin(NINE);
        }
        else if(BACKSPACE.equals((e.getActionCommand()))){
            removeFromPin();
        }
        else if(ENTER.equals(e.getActionCommand())){
            System.exit(0);
        }
        else {
            throw new RuntimeException("Unrecognized action");
        }
    }
    private void addToPin(String number){
        pinString=pinString+number;
    }
    private void removeFromPin(){
        pinString=pinString.substring(0,pinString.length()-1);
    }
}
