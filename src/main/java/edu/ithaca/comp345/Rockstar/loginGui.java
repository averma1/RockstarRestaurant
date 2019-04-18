package edu.ithaca.comp345.Rockstar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class loginGui {

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

        LoginTextDisplay displayPanel = new LoginTextDisplay();
        displayPanel.setBackground(Color.pink);
        JButton okButton = new JButton("OK");
        ButtonHandler listener = new ButtonHandler();
        okButton.addActionListener(listener);


        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(okButton, BorderLayout.SOUTH);

        JFrame window = new JFrame("GUI Test");
        window.setContentPane(content);
        window.setSize(250,100);

        window.setLocation(100,100);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);


    }

}
