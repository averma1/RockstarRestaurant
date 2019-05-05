package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.managerApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
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
    public static final String EXIT="Exit";
    public String pinString="";

    private managerApi managerAPI;
    private LoginView loginView;
    private StateController stateController;

    public LoginController(LoginView loginView, managerApi managerAPI, StateController stateController){
        this.managerAPI = managerAPI;
        this.loginView = loginView;
        this.stateController = stateController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ZERO.equals(e.getActionCommand())){
            addToPin("0");
        }
        if (ONE.equals(e.getActionCommand())){
            addToPin("1");
        }
        if (TWO.equals(e.getActionCommand())){
            addToPin("2");
        }
        if (THREE.equals(e.getActionCommand())){
            addToPin("3");
        }
        if (FOUR.equals(e.getActionCommand())){
            addToPin("4");
        }
        if (FIVE.equals(e.getActionCommand())){
            addToPin("5");
        }
        if (SIX.equals(e.getActionCommand())){
            addToPin("6");
        }
        if (SEVEN.equals(e.getActionCommand())){
            addToPin("7");
        }
        if (EIGHT.equals(e.getActionCommand())){
            addToPin("8");
        }
        if (NINE.equals(e.getActionCommand())){
            addToPin("9");
        }
        else if(BACKSPACE.equals((e.getActionCommand()))){
            removeFromPin();
        }
        else if(ENTER.equals(e.getActionCommand())){
            attemptLogin(pinString);
        }
        else if(EXIT.equals(e.getActionCommand())){
            exitSystem();
        }
        /*else {
            throw new RuntimeException("Unrecognized action");
        }*/
    }
    public String getPinString(){
        return pinString;
    }
    private void addToPin(String number){
        pinString=pinString+number;
        updateStringView();
    }
    private void removeFromPin(){
        pinString=pinString.substring(0,pinString.length()-1);
        updateStringView();
    }
    public void updateStringView(){
        loginView.pinEnter.setText(getPinString());
        if (pinString.length()==0){
            loginView.pinEnter.setText(loginView.pin);
        }
    }
    public void exitSystem(){
        System.exit(0);
    }
    public void attemptLogin(String strPin){
        if (managerAPI.isLoginPinValid(Integer.parseInt(strPin))){
            //The employee does exist, log them in
            stateController.login(pinString);
        }
        else {
            loginView.showMessage("Invalid PIN");
        }
    }
}
