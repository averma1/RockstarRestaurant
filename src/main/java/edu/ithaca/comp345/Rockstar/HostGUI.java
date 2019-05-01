package edu.ithaca.comp345.Rockstar;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class HostGUI extends JPanel{

    private HostUI controller;
//    private JLabel seatDisplay;
    private JLabel tableDisplay;
    private DefaultListModel tableListModel;
    private JTextArea amountBox;
    private JButton tableButton;
    private JTextArea textArea;

    private JList<Integer> tableList;

    public HostGUI(hostApi hostApi, Employee host){
        this.controller = new HostUI(this, hostApi, host);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createTableDisplayPanel());
        this.add(createListOfTablesPanel());
        this.add(createActionPanel(controller));
        this.add(entryBoxPanel());

        this.setSize(1000, 1000);
//        updateView();

    }

    private JPanel createActionPanel(ActionListener controller){
        amountBox = new JTextArea();

        tableButton = new JButton(HostUI.SEAT);
        tableButton.setActionCommand(HostUI.SEAT);
        tableButton.addActionListener(controller);
        JPanel seatPanel = new JPanel();
        seatPanel.add(tableButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
//        actionPanel.add(amountBox, BorderLayout.PAGE_END);
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
                addToTableList(all.get(i).getNumOfSeatsFilled());
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


    public void addToTableList(int num){
        tableListModel.addElement(num);
    }


    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

}
