package edu.ithaca.comp345.Rockstar;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class BartenderGui extends JPanel {
    private BartenderUI controller;

    //Keep any visualized objects you intend to change as data members
    private JLabel seatDisplay;
    private JButton seatButton;
    private JButton payButton;

    public BartenderGui(BartenderApi BartenderAPI){
        this.controller = new BartenderUI(this, BartenderAPI);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createSeatDisplayPanel());
        this.add(createActionPanel(controller));
        this.add(createListOfOrdersPanel());
        this.add(createListOfMenuItemsPanel());

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

    private JPanel createListOfOrdersPanel(){
        JPanel orderDisplayPanel = new JPanel();
        Integer[] data = controller.getOrdersList();

        JList<Integer> list = new JList<>(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(100, 100));

        orderDisplayPanel.add(listScroller);

        return orderDisplayPanel;
    }

    private JPanel createListOfMenuItemsPanel(){
        JPanel menuDisplayPanel = new JPanel();

        String[] data = controller.getMenu();

        JList<String> list = new JList<>(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(100, 100));

        menuDisplayPanel.add(listScroller);

        return menuDisplayPanel;
    }

    private JPanel createActionPanel(ActionListener controller){

        payButton = new JButton(BartenderUI.PAY);
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
        actionPanel.add(payPanel,BorderLayout.LINE_START);
        actionPanel.add(orderPanel);
        actionPanel.add(seatPanel,BorderLayout.LINE_END);

        return actionPanel;
    }

    public void updateView(){
        String amount= ""+controller.getRemainingSeatsUI();
        seatDisplay.setText(amount);
        if (controller.canSeat()){
            seatButton.setEnabled(true);
        }
        else {
            seatButton.setEnabled(false);
        }
        if(controller.getOrders().size()==0){
            payButton.setEnabled(false);
        } else {
            payButton.setEnabled(true);
        }
    }


    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
