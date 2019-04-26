package edu.ithaca.comp345.Rockstar;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class BartenderGui extends JPanel {
    private BartenderUI controller;

    //Keep any visualized objects you intend to change as data members
    private JLabel seatDisplay;
    private static JTextArea amountBox;
    private JButton seatButton;

    public BartenderGui(BartenderApi BartenderAPI){
        this.controller = new BartenderUI(this, BartenderAPI);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createSeatDisplayPanel());
        this.add(createActionPanel(controller));

        updateView();
    }

    private JPanel createSeatDisplayPanel(){
        JPanel seatDisplayPanel = new JPanel();
        seatDisplayPanel.setLayout(new FlowLayout());

        JLabel seatLabel = new JLabel("Amount of Seats Available:");
        seatDisplayPanel.add(seatLabel);

        seatDisplay = new JLabel();
        seatDisplayPanel.add(seatDisplay);

        return seatDisplayPanel;
    }

    private JPanel createActionPanel(ActionListener controller){
        amountBox = new JTextArea();

        JButton payButton = new JButton(BartenderUI.PAY);
        payButton.setActionCommand(BartenderUI.PAY);
        payButton.addActionListener(controller);
        JPanel payPanel = new JPanel();
        payPanel.add(payButton);

        JButton orderButton = new JButton(BartenderUI.ORDER);
        orderButton.setActionCommand(BartenderUI.ORDER);
        orderButton.addActionListener(controller);
        JPanel orderPanel = new JPanel();
        orderPanel.add(orderButton);

        seatButton = new JButton(BartenderUI.SEAT);
        seatButton.setActionCommand(BartenderUI.SEAT);
        seatButton.addActionListener(controller);
        JPanel seatPanel = new JPanel();
        seatPanel.add(seatButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(amountBox, BorderLayout.PAGE_START);
        actionPanel.add(payPanel,BorderLayout.LINE_START);
        actionPanel.add(orderPanel);
        actionPanel.add(seatPanel,BorderLayout.LINE_END);

        return actionPanel;
    }

    public void updateView(){
        String amount= ""+controller.getRemainingSeatsUI();
        seatDisplay.setText(amount);
        if (controller.seatPerson(1)){
            seatButton.setEnabled(true);
        }
        else {
            seatButton.setEnabled(false);
        }
    }

    public static String getAmount(){
        return amountBox.getText();
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
