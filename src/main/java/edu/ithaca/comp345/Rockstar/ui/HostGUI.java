package edu.ithaca.comp345.Rockstar.ui;

import edu.ithaca.comp345.Rockstar.Employee;
import edu.ithaca.comp345.Rockstar.Table;
import edu.ithaca.comp345.Rockstar.hostApi;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class HostGUI extends JPanel{

    private HostUI controller;
//    private JLabel seatDisplay;
    private JLabel tableDisplay;
    private DefaultListModel tableListModel;
    private DefaultListModel seatsFilledListModel;
    private RestaurantView restaurantView;
    private JButton tableButton;
    private JTextArea textArea;
    private JButton logoutBtn;

    private JList<Integer> tableList;
    private JList<Integer> filledSeatsList;

    public HostGUI(hostApi hostApi, Employee host, RestaurantView restaurantView){
        this.controller = new HostUI(this, hostApi, host, restaurantView);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createButtonPanel(controller));
        this.add(createTableDisplayPanel());
        this.add(createListOfTablesPanel());
        this.add(createTableFilledDisplayPanel());
        this.add(createTablesFilledPanel());
        this.add(createEntryDisplayPanel());
        this.add(entryBoxPanel());
        this.add(createActionPanel(controller));

        this.setSize(1000, 1000);
    }

    private JPanel createActionPanel(ActionListener controller){
        tableButton = new JButton(HostUI.SEAT);
        tableButton.setActionCommand(HostUI.SEAT);
        tableButton.addActionListener(controller);
        JPanel seatPanel = new JPanel();
        seatPanel.add(tableButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(seatPanel,BorderLayout.LINE_START);

        return actionPanel;
    }

    private JPanel entryBoxPanel(){
        textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(true);
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(textArea, BorderLayout.PAGE_END);
        return actionPanel;
    }

    public String getAmount(){
        return textArea.getText();
    }

    private JPanel createTableDisplayPanel(){
        JPanel tableDisplayPanel = new JPanel();
        tableDisplayPanel.setLayout(new FlowLayout());

        JLabel tableLabel = new JLabel("All Tables: ");
        tableDisplayPanel.add(tableLabel);

        tableDisplay = new JLabel();
        tableDisplayPanel.add(tableDisplay);

        return tableDisplayPanel;
    }

    private JPanel createTableFilledDisplayPanel(){
        JPanel tableDisplayPanel = new JPanel();
        tableDisplayPanel.setLayout(new FlowLayout());

        JLabel tableLabel = new JLabel("Filled Seats: ");
        tableDisplayPanel.add(tableLabel);

        tableDisplay = new JLabel();
        tableDisplayPanel.add(tableDisplay);

        return tableDisplayPanel;
    }

    private JPanel createEntryDisplayPanel(){
        JPanel tableDisplayPanel = new JPanel();
        tableDisplayPanel.setLayout(new FlowLayout());

        JLabel tableLabel = new JLabel("Enter a Number of People to Seat: ");
        tableDisplayPanel.add(tableLabel);

        tableDisplay = new JLabel();
        tableDisplayPanel.add(tableDisplay);

        return tableDisplayPanel;
    }

    public int tableSelected(){
        if(tableList.getSelectedValue()==null){
            return -1;
        } else {
            return tableList.getSelectedValue();
        }
    }


    private JPanel createListOfTablesPanel(){
        JPanel tableDisplayPanel = new JPanel();
        tableListModel = new DefaultListModel();

        List<Table> all = controller.getTables();
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


    private JPanel createTablesFilledPanel() {

        JPanel tableDisplayPanel = new JPanel();
        seatsFilledListModel = new DefaultListModel();

        List<Table> all = controller.getTables();
        if (all != null) {
            for (int i = 0; i < all.size(); i++) {
                addToFilledSeatsList(all.get(i).getNumOfSeatsFilled());
                System.out.println(all.get(i).getNumOfSeatsFilled());
            }
        }

        filledSeatsList = new JList<>(seatsFilledListModel);
        filledSeatsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        filledSeatsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        filledSeatsList.setVisibleRowCount(-1);

        JScrollPane tableListScroller = new JScrollPane(filledSeatsList);
        tableListScroller.setPreferredSize(new Dimension(200, 200));

        tableDisplayPanel.add(tableListScroller);
        tableDisplayPanel.setLocation(100, 0);

        return tableDisplayPanel;
    }

    public void updateFilledTables(){
        List<Table> all = controller.getTables();
        seatsFilledListModel.clear();
        if (all != null) {
            for (int i = 0; i < all.size(); i++) {
                addToFilledSeatsList(all.get(i).getNumOfSeatsFilled());
            }
        }
    }


    public void addToTableList(int num){
        tableListModel.addElement(num);
    }

    public void addToFilledSeatsList(int num){
        seatsFilledListModel.addElement(num);
    }


    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    private JPanel createButtonPanel(ActionListener controller) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        logoutBtn = new JButton("Logout");
        buttonPanel.add(logoutBtn);
        logoutBtn.setActionCommand(ManagerController.LOGOUT);
        logoutBtn.addActionListener(controller);
        return buttonPanel;
    }

}
