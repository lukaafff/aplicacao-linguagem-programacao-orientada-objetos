package Aulas.Swing.JOptionPane;

import javax.swing.*;

public class JOptionPaneExample3 {
    JFrame f;

    JOptionPaneExample3() {
        f = new JFrame();
        String name = JOptionPane.showInputDialog(f, "Enter Name");
    }

    public static void main(String[] args) {
        new JOptionPaneExample3();
    }
}
