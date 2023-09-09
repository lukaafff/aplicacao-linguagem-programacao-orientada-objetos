package Aulas.Swing.JTable;

import javax.swing.*;

public class JTableExemple {
    JFrame f;
    JTableExemple() {
        f = new JFrame();
        String dados[][] = { {"101", "Amit", "670000"}, 
        {"102","Jai","780000"},
        {"101","Sachin","700000"}};
        String coluna [] = {"ID", "NOME", "SALÁRIO"};   
        JTable jt = new JTable(dados, coluna);
        jt.setBounds (30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 400);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new JTableExemple();
    }
}
