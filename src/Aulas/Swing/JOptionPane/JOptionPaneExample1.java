package Aulas.Swing.JOptionPane;

import javax.swing.*;

public class JOptionPaneExample1 {
    JFrame f;

    JOptionPaneExample1() {
        f = new JFrame ();
        JOptionPane.showMessageDialog(f, "Hello, Welcome to Javatpoint");
    }

    public static void main(String[] args) {
        new JOptionPaneExample1();
    }
}
