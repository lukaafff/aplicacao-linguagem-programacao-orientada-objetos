package Aulas.Swing.JOptionPane;

import javax.swing.*;

public class JOptionPaneExample2 {
    JFrame f;

    JOptionPaneExample2() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "Successfully Updated", "Alert", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new JOptionPaneExample2();
    }
}
