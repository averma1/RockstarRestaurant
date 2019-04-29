package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.managerApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    public static final String LOG_IN = "Login";

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
        if (LOG_IN.equals(e.getActionCommand())){
            attemptLogin(loginView.getPinEntered());
        }
        else {
            throw new RuntimeException("Unrecognized action");
        }
    }

    public void attemptLogin(String strPin){
        if (managerAPI.isLoginPinValid(Integer.parseInt(strPin))){

            //The employee does exist, log them in
            stateController.login(strPin);
        }
        else {
            loginView.showMessage("Invalid PIN");
        }
    }
}
