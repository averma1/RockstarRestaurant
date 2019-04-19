package edu.ithaca.comp345.Rockstar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.GridLayout;

public class loginGui extends JPanel {

    private static class LoginTextDisplay extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(new Font("Times", Font.BOLD, 50));
            g.drawString( "Login!", 600, 100 );
        }
    }

    private static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        int width=JFrame.MAXIMIZED_HORIZ;
        int height=JFrame.MAXIMIZED_VERT;

        LoginTextDisplay displayPanel = new LoginTextDisplay();
        displayPanel.setBackground(Color.cyan);
        JButton button = new JButton();
        ButtonHandler listener = new ButtonHandler();
        button.addActionListener(listener);



        JTextField pinEnter= new javax.swing.JTextField("Enter Pin");
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

        /**
        button.setLocation(100,100);
        button.addActionListener(listener);
        content.add(button);
        for (int i=9; i >=0; i--) {
            button = new JButton(Integer.toString(i));
            button.setLocation(button.getWidth()-width/2,button.getY()-height/2);
            content.add(button);
            button.addActionListener(listener);
        }**/
        JFrame window = new JFrame("GUI Test");
        window.setContentPane(content);
        window.setSize(250, 100);

        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);



    }


}
