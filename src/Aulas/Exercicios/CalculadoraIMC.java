package Aulas.Exercicios;

import java.awt.*;
import javax.swing.*;

public class CalculadoraIMC {
    JFrame frame;

    CalculadoraIMC () {
        frame = new JFrame();

        JLabel lPeso = new JLabel("Peso:");
        JTextField tfPeso = new JTextField();

        JLabel lAltura = new JLabel("Altura:");
        JTextField tfAltura = new JTextField();

        JButton ctCalcula = new JButton("Calcular");


        frame.add(lPeso);
        frame.add(tfPeso);
        frame.add(lAltura);
        frame.add(tfAltura);
        frame.add(ctCalcula);
        
        frame.setLayout(new GridLayout(5, 1));
        frame.setSize(300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculadoraIMC();
    }
}
