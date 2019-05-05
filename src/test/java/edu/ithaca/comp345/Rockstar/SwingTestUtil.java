package edu.ithaca.comp345.Rockstar;

import javax.swing.*;
import java.awt.*;

public class SwingTestUtil {

    public static void showPanelInTestFrame(JPanel panelToTest){
        JFrame testFrame = new JFrame("Rockstar Restaurant GUI");
        testFrame.add(panelToTest);
        testFrame.pack();
        testFrame.setVisible(true);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
