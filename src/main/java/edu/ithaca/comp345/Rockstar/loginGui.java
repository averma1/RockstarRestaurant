package edu.ithaca.comp345.Rockstar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;

public class loginGui extends JPanel {

    private static class LoginTextDisplay extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(new Font("Times", Font.BOLD, 50));
            g.drawString( "Login!", getWidth()/2, getHeight()-(getHeight()/6) );
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

        JButton button;
        ButtonHandler listener = new ButtonHandler();

        JPanel welcomePanel= new JPanel();
        JPanel wrapper= new JPanel();
        JPanel topBox= new JPanel();
        JPanel keypad= new JPanel();
        JPanel keypadPanel= new JPanel();
        JPanel pinEnterPanel= new JPanel();

        /**
        LoginTextDisplay displayPanel = new LoginTextDisplay();
        displayPanel.setBackground(Color.cyan);
        welcomePanel.add(displayPanel);
        wrapper.add(welcomePanel);
        **/

        JTextField pinEnter= new javax.swing.JTextField("Enter Pin");
        pinEnter.setEditable(false);

        wrapper.setLayout(new BoxLayout(wrapper,BoxLayout.PAGE_AXIS));

        pinEnterPanel.add(pinEnter);
        topBox.add(pinEnterPanel);
        wrapper.add(topBox);

        keypad.setLayout(new GridLayout(4,3));
        for (int i = 9; i >= 1; i--) {
            button = new JButton(Integer.toString(i));
            keypad.add(button);
            button.addActionListener(listener);
        }

        //Adds the other three buttons
        //Backspace Button
        JButton backSpaceButton= new JButton("Delete");
        keypad.add(backSpaceButton);
        backSpaceButton.addActionListener(listener);
        //0 button
        button=new JButton("0");
        keypad.add(button);
        button.addActionListener(listener);
        //Enter button
        JButton enterButton= new JButton("Enter");
        keypad.add(enterButton);
        enterButton.addActionListener(listener);
        //Adds keypad to its own panel
        //keypadPanel.add(keypad);

        wrapper.add(keypad);
        //Sets window specs
        JFrame window = new JFrame("System Login");
        window.setContentPane(wrapper);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);



    }


}
