package Aulas.Swing.Panel;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class PanelSimples extends JFrame {
    JPanel p1, p2, p3;

    JLabel lb1, lb2, lb3;

    PanelSimples() {
        setLayout(new FlowLayout());
        p1 = new JPanel();
        lb1 = new JLabel("Panel 1 red");
        lb1.setForeground(Color.white);
        p1.add(lb1);
        JButton bt1 = new JButton("Botão 1");
        p1.add(bt1);
        p1.setBackground(Color.red);
        add(p1);

        p2 = new JPanel();
        lb2 = new JLabel("Panel 2 blue");
        lb2.setForeground(Color.white);
        p2.add(lb2);
        JButton bt2 = new JButton("Botão 2");
        p2.add(bt2);
        p2.setBackground(Color.blue);
        add(p2);
    }

    public static void main(String[] args) {
        JFrame PanelSimples = new PanelSimples();
        PanelSimples.setTitle("Exemplo de painel Java AWT");
        PanelSimples.setSize(500,300);
        PanelSimples.setVisible(true);
    }
    
}
