package edu.ithaca.comp345.Rockstar;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class BartenderGui extends JPanel {
    private BartenderUI controller;

    //Keep any visualized objects you intend to change as data members
    private JLabel seatDisplay;
    private JButton seatButton;
    private JButton payButton;
    private JLabel orderDisplay;
    private DefaultListModel listModel;
    private JList<Integer> orderList;
    private JList<String> menuList;

    public BartenderGui(BartenderApi BartenderAPI){
        this.controller = new BartenderUI(this, BartenderAPI);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createSeatDisplayPanel());
        this.add(createActionPanel(controller));
        this.add(createActionPanel2(controller));
        this.add(createListOfOrdersPanel());
        this.add(createListOfMenuItemsPanel());
        this.add(createOrderDisplayPanel());
        this.add(createActionPanel3(controller));

        this.setSize(1000, 1000);
        updateView();
    }

    private JPanel createOrderDisplayPanel(){
        JPanel seatDisplayPanel = new JPanel();
        seatDisplayPanel.setLayout(new FlowLayout());

        JLabel seatLabel = new JLabel("Order Items:");
        seatDisplayPanel.add(seatLabel);

        orderDisplay = new JLabel();
        seatDisplayPanel.add(orderDisplay);

        return seatDisplayPanel;
    }

    public void setOrderList(List<Order> orders){
        String message= "";
        for(int i=0; i<orders.size(); i++){
            Order currentOrder= orders.get(i);
            List<MenuItem> currentItems= currentOrder.getItems();
            message= message+"Order #"+ currentOrder.getNumber()+": ";
            for(int x=0; x<currentItems.size(); x++){
                MenuItem current= currentItems.get(x);
                message= message+current.getItemName()+" $"+current.getPrice()+" ";
            }
            message+="          ";
        }
        orderDisplay.setText(message);
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
        JLabel orderLabel = new JLabel("Orders:");
        orderDisplayPanel.add(orderLabel);
        listModel = new DefaultListModel();
        List<Order> all= controller.getOrders();
        for(int i=0; i<all.size(); i++){
            addToOrderList(all.get(i).number);
        }

        orderList = new JList<>(listModel);
        orderList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        orderList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        orderList.setVisibleRowCount(-1);

        JScrollPane orderListScroller = new JScrollPane(orderList);
        orderListScroller.setPreferredSize(new Dimension(200, 200));

        orderDisplayPanel.add(orderListScroller);
        orderDisplayPanel.setLocation(100, 0);

        return orderDisplayPanel;
    }

    public void addToOrderList(int num){
        listModel.addElement(num);
    }

    public void deleteFromOrderList(int num){
        listModel.removeElement(num);
    }

    public String menuItemSelected(){
        return menuList.getSelectedValue();
    }

    public int orderSelected(){
        if(orderList.getSelectedValue()==null){
            return -1;
        } else {
            return orderList.getSelectedValue();
        }
    }

    private JPanel createListOfMenuItemsPanel(){
        JPanel menuDisplayPanel = new JPanel();

        JLabel menuLabel = new JLabel("Menu:");
        menuDisplayPanel.add(menuLabel);
        String[] data = controller.getMenu();

        menuList = new JList<>(data);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        menuList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        menuList.setVisibleRowCount(-1);

        JScrollPane listScroller = new JScrollPane(menuList);
        listScroller.setPreferredSize(new Dimension(200, 200));

        menuDisplayPanel.add(listScroller);
        menuDisplayPanel.setLocation(100, 150);

        return menuDisplayPanel;
    }

    private JPanel createActionPanel(ActionListener controller){
        seatButton = new JButton(BartenderUI.SEAT);
        seatButton.setActionCommand(BartenderUI.SEAT);
        seatButton.addActionListener(controller);
        JPanel seatPanel = new JPanel();
        seatPanel.add(seatButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(seatPanel);

        return actionPanel;
    }

    private JPanel createActionPanel2(ActionListener controller){
        JButton createButton = new JButton(BartenderUI.CREATE);
        createButton.setActionCommand(BartenderUI.CREATE);
        createButton.addActionListener(controller);
        JPanel seatPanel = new JPanel();
        seatPanel.add(createButton);

        JButton seeOrdersButton = new JButton(BartenderUI.SEE);
        seeOrdersButton.setActionCommand(BartenderUI.SEE);
        seeOrdersButton.addActionListener(controller);
        JPanel seeOrdersPanel = new JPanel();
        seeOrdersPanel.add(seeOrdersButton);

        JButton orderButton = new JButton(BartenderUI.ORDER);
        orderButton.setActionCommand(BartenderUI.ORDER);
        orderButton.addActionListener(controller);
        JPanel orderPanel = new JPanel();
        orderPanel.add(orderButton);


        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(seatPanel,BorderLayout.LINE_START);
        actionPanel.add(orderPanel);
        actionPanel.add(seeOrdersPanel,BorderLayout.LINE_END);

        return actionPanel;
    }

    private JPanel createActionPanel3(ActionListener controller){
        payButton = new JButton(BartenderUI.PAY);
        payButton.setActionCommand(BartenderUI.PAY);
        payButton.addActionListener(controller);
        JPanel payPanel = new JPanel();
        payPanel.add(payButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(payPanel);

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
