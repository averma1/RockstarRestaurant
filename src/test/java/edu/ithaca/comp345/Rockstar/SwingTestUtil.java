package edu.ithaca.comp345.Rockstar;

import javax.swing.*;

public class SwingTestUtil {

    public static void showPanelInTestFrame(JPanel panelToTest){
        JFrame testFrame = new JFrame();
        testFrame.add(panelToTest);
        testFrame.pack();
        testFrame.setVisible(true);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
