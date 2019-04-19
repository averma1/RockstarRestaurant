package edu.ithaca.comp345.Rockstar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.GridLayout;

public class loginGui extends JPanel {

    public static class testDisplay extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Hello World!", 80, 30);
        }
    }

    private static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        testDisplay displayPanel = new testDisplay();
        displayPanel.setBackground(Color.cyan);
        JButton button = new JButton();
        ButtonHandler listener = new ButtonHandler();
        button.addActionListener(listener);


        JTextArea pinEnter = new JTextArea("Enter Pin...");
        pinEnter.setEditable(false);
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(pinEnter, BorderLayout.NORTH);
        int col = 3;
        int row = 4;
        content.setLayout(new GridLayout(row, col));
        for (int i = 9; i >= 0; i--) {
            button = new JButton(Integer.toString(i));
            content.add(button);
            button.addActionListener(listener);
        }

        JFrame window = new JFrame("GUI Test");
        window.setContentPane(content);
        window.setSize(250, 100);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
