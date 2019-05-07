package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.Employee;
import edu.ithaca.comp345.Rockstar.MenuItem;
import edu.ithaca.comp345.Rockstar.Order;
import edu.ithaca.comp345.Rockstar.Table;
import edu.ithaca.comp345.Rockstar.WaiterApi;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class WaiterView extends JPanel {
    private WaiterController controller;

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
    private RestaurantView restaurantView;

    public WaiterView(WaiterApi WaiterAPI, Employee waiter, RestaurantView restaurantView){
        this.restaurantView = restaurantView;
        this.controller = new WaiterController(this, WaiterAPI, waiter, restaurantView);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createActionPanel4(controller));
        this.add(createSeatDisplayPanel());
        this.add(createActionPanel(controller));
        this.add(createActionPanel3(controller));
        this.add(createListOfMenuItemsPanel());
        this.add(createListOfTablesPanel());
        orderLists=(createListOfOrdersPanel());
        this.add(orderLists);
        this.add(createOrderDisplayPanel());
        this.add(createActionPanel2(controller));

        //this.setSize(1000, 1000);
        updateView();
    }

    /**
     * creates the panel where the orders are displayed
     * @return seatDisplayPanel
     */
    private JPanel createOrderDisplayPanel(){
        JPanel seatDisplayPanel = new JPanel();
        seatDisplayPanel.setLayout(new FlowLayout());

        JLabel seatLabel = new JLabel("Order Items:");
        seatDisplayPanel.add(seatLabel);

        orderDisplay = new JLabel();
        seatDisplayPanel.add(orderDisplay);

        return seatDisplayPanel;
    }

    /**
     * creates the panel where the seats are displayed
     * @return seatDisplayPanel
     */
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

    /**
     * creates the list of orders panel
     * @return orderDisplayPanel
     */
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
        orderListScroller.setPreferredSize(new Dimension(200, 150));

        orderDisplayPanel.add(orderListScroller);
        orderDisplayPanel.setLocation(100, 0);

        return orderDisplayPanel;
    }


    /**
     * allows user to view orders
     */
    public void viewOrders(int tableNum){
        orderListModel.clear();
        List<Order> all= controller.getOrders(tableNum);
        if(all!=null) {
            for (int i = 0; i < all.size(); i++) {
                addToOrderList(all.get(i).number);
            }
        }
    }

    /**
     * adds to order
     * @param: num, the order num
     */
    public void addToOrderList(int num){
        orderListModel.addElement(num);
    }

    /**
     * clears that order
     */
    public void clearOrderList(){
        orderListModel.clear();
    }

    /**
     * sets the order list
     * @param orders, list of orders
     */
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

    /**
     * creates the list of menu items panel
     */
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
        listScroller.setPreferredSize(new Dimension(200, 150));

        menuDisplayPanel.add(listScroller);
        menuDisplayPanel.setLocation(100, 150);

        return menuDisplayPanel;
    }

    /**
     * creates list of tables panel
     */
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
        tableListScroller.setPreferredSize(new Dimension(200, 150));

        tableDisplayPanel.add(tableListScroller);
        tableDisplayPanel.setLocation(100, 0);

        return tableDisplayPanel;
    }

    /**
     * handles table selection
     */
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

    /**
     * creates the action panel
     */
    private JPanel createActionPanel(ActionListener controller){
        JButton orderButton = new JButton(WaiterController.ORDER);
        orderButton.setActionCommand(WaiterController.ORDER);
        orderButton.addActionListener(controller);
        JPanel orderPanel = new JPanel();
        orderPanel.add(orderButton);

        createButton = new JButton(WaiterController.CREATE);
        createButton.setActionCommand(WaiterController.CREATE);
        createButton.addActionListener(controller);
        JPanel seatPanel = new JPanel();
        seatPanel.add(createButton);

        JButton seeOrdersButton = new JButton(WaiterController.SEE);
        seeOrdersButton.setActionCommand(WaiterController.SEE);
        seeOrdersButton.addActionListener(controller);
        JPanel seeOrdersPanel = new JPanel();
        seeOrdersPanel.add(seeOrdersButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(seatPanel,BorderLayout.LINE_START);
        actionPanel.add(seeOrdersPanel);
        actionPanel.add(orderPanel,BorderLayout.LINE_END);

        return actionPanel;
    }

    private JPanel createActionPanel3(ActionListener controller){
        JLabel Label = new JLabel("Enter Values Here:");
        amountBox = new JTextArea();

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(Label,BorderLayout.LINE_START);
        actionPanel.add(amountBox,BorderLayout.PAGE_END);

        return actionPanel;
    }

    public String getAmount(){
        return amountBox.getText();
    }

    private JPanel createActionPanel2(ActionListener controller){
        payButton = new JButton(WaiterController.PAY);
        payButton.setActionCommand(WaiterController.PAY);
        payButton.addActionListener(controller);
        JPanel payPanel = new JPanel();
        payPanel.add(payButton);

        JButton splitotButton = new JButton(WaiterController.SPLITOT);
        splitotButton.setActionCommand(WaiterController.SPLITOT);
        splitotButton.addActionListener(controller);
        JPanel splitotPanel = new JPanel();
        splitotPanel.add(splitotButton);

        JButton splitOrdsButton = new JButton(WaiterController.SPLITORD);
        splitOrdsButton.setActionCommand(WaiterController.SPLITORD);
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

    private JPanel createActionPanel4(ActionListener controller){
        JButton helpButton = new JButton(WaiterController.HELP);
        helpButton.setActionCommand(WaiterController.HELP);
        helpButton.addActionListener(controller);
        JPanel helpPanel = new JPanel();
        helpPanel.add(helpButton);

        JButton backButton = new JButton(WaiterController.LOGOUT);
        backButton.setActionCommand(WaiterController.LOGOUT);
        backButton.addActionListener(controller);
        JPanel backPanel = new JPanel();
        backPanel.add(backButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(helpPanel,BorderLayout.LINE_START);
        actionPanel.add(backPanel,BorderLayout.LINE_END);

        return actionPanel;
    }


    public void updateView(){
//
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
