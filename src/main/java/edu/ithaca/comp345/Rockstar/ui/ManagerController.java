package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.managerApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerController implements ActionListener {


    private ManagerView managerView;
    private managerApi managerAPI;
    private String strPin;

    public ManagerController(ManagerView managerView, managerApi managerAPI, String strPin){
        this.managerView = managerView;
        this.managerAPI = managerAPI;
        this.strPin = strPin;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
    }

}
