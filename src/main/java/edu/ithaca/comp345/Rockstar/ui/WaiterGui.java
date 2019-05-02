package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.Employee;
import edu.ithaca.comp345.Rockstar.MenuItem;
import edu.ithaca.comp345.Rockstar.Order;
import edu.ithaca.comp345.Rockstar.Table;
import edu.ithaca.comp345.Rockstar.waiterApi;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class WaiterGui extends JPanel {
    private WaiterUI controller;

    //Keep any visualized objects you intend to change as data members
    private JLabel seatDisplay;
    private JLabel orderDisplay;
    private JButton createButton;
    private JButton payButton;
    private JTextArea amountBox;
    private DefaultListModel orderListModel;
    private DefaultListModel tableListModel;
    private JList<Integer> orderList;
    private JList<String> menuList;
    private JList<Integer> tableList;
    public JPanel orderLists;

    public WaiterGui(waiterApi WaiterAPI, Employee waiter){
        this.controller = new WaiterUI(this, WaiterAPI, waiter);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createSeatDisplayPanel());
        this.add(createActionPanel(controller));
        this.add(createListOfMenuItemsPanel());
        this.add(createListOfTablesPanel());
        orderLists=(createListOfOrdersPanel());
        this.add(orderLists);
        this.add(createOrderDisplayPanel());
        this.add(createActionPanel2(controller));

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

    private JPanel createSeatDisplayPanel(){
        JPanel seatDisplayPanel = new JPanel();
        seatDisplayPanel.setLayout(new FlowLayout());

        JLabel seatLabel = new JLabel("Current User:");
        seatDisplayPanel.add(seatLabel);

        JLabel nameLabel = new JLabel(controller.getName());
        seatDisplayPanel.add(nameLabel);

        seatDisplay = new JLabel();
        seatDisplayPanel.add(seatDisplay);

        return seatDisplayPanel;
    }

    private JPanel createListOfOrdersPanel(){
        JPanel orderDisplayPanel = new JPanel();

        JLabel orderLabel = new JLabel("Orders:");
        orderDisplayPanel.add(orderLabel);
        orderListModel = new DefaultListModel();
        orderList = new JList<>(orderListModel);
        orderList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        orderList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        orderList.setVisibleRowCount(-1);

        JScrollPane orderListScroller = new JScrollPane(orderList);
        orderListScroller.setPreferredSize(new Dimension(200, 200));

        orderDisplayPanel.add(orderListScroller);
        orderDisplayPanel.setLocation(100, 0);

        return orderDisplayPanel;
    }

    public void viewOrders(int tableNum){
        orderListModel.clear();
        List<Order> all= controller.getOrders(tableNum);
        if(all!=null) {
            for (int i = 0; i < all.size(); i++) {
                addToOrderList(all.get(i).number);
            }
        }
    }

    public void addToOrderList(int num){
        orderListModel.addElement(num);
    }

    public void clearOrderList(){
        orderListModel.clear();
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

    private JPanel createListOfTablesPanel(){
        JPanel tableDisplayPanel = new JPanel();
        tableListModel = new DefaultListModel();

        JLabel tableLabel = new JLabel("Tables:");
        tableDisplayPanel.add(tableLabel);
        List<Table> all= controller.getTables();
        if(all!=null) {
            for (int i = 0; i < all.size(); i++) {
                addToTableList(all.get(i).getTableNumber());
            }
        }
        tableList = new JList<>(tableListModel);
        tableList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        tableList.setVisibleRowCount(-1);

        JScrollPane tableListScroller = new JScrollPane(tableList);
        tableListScroller.setPreferredSize(new Dimension(200, 200));

        tableDisplayPanel.add(tableListScroller);
        tableDisplayPanel.setLocation(100, 0);

        return tableDisplayPanel;
    }

    public int tableSelected(){
        if(tableList.getSelectedValue()==null){
            return -1;
        } else {
            return tableList.getSelectedValue();
        }
    }

    public void addToTableList(int num){
        tableListModel.addElement(num);
    }

    private JPanel createActionPanel(ActionListener controller){
        amountBox = new JTextArea();

        JButton orderButton = new JButton(WaiterUI.ORDER);
        orderButton.setActionCommand(WaiterUI.ORDER);
        orderButton.addActionListener(controller);
        JPanel orderPanel = new JPanel();
        orderPanel.add(orderButton);

        createButton = new JButton(WaiterUI.CREATE);
        createButton.setActionCommand(WaiterUI.CREATE);
        createButton.addActionListener(controller);
        JPanel seatPanel = new JPanel();
        seatPanel.add(createButton);

        JButton seeOrdersButton = new JButton(WaiterUI.SEE);
        seeOrdersButton.setActionCommand(WaiterUI.SEE);
        seeOrdersButton.addActionListener(controller);
        JPanel seeOrdersPanel = new JPanel();
        seeOrdersPanel.add(seeOrdersButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(amountBox, BorderLayout.PAGE_END);
        actionPanel.add(seatPanel,BorderLayout.LINE_START);
        actionPanel.add(seeOrdersPanel);
        actionPanel.add(orderPanel,BorderLayout.LINE_END);

        return actionPanel;
    }

    public String getAmount(){
        return amountBox.getText();
    }

    private JPanel createActionPanel2(ActionListener controller){
        payButton = new JButton(WaiterUI.PAY);
        payButton.setActionCommand(WaiterUI.PAY);
        payButton.addActionListener(controller);
        JPanel payPanel = new JPanel();
        payPanel.add(payButton);

        JButton splitotButton = new JButton(WaiterUI.SPLITOT);
        splitotButton.setActionCommand(WaiterUI.SPLITOT);
        splitotButton.addActionListener(controller);
        JPanel splitotPanel = new JPanel();
        splitotPanel.add(splitotButton);

        JButton splitOrdsButton = new JButton(WaiterUI.SPLITORD);
        splitOrdsButton.setActionCommand(WaiterUI.SPLITORD);
        splitOrdsButton.addActionListener(controller);
        JPanel splitOrdPanel = new JPanel();
        splitOrdPanel.add(splitOrdsButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(payPanel,BorderLayout.LINE_START);
        actionPanel.add(splitotPanel);
        actionPanel.add(splitOrdPanel,BorderLayout.LINE_END);

        return actionPanel;
    }


    public void updateView(){
//
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
