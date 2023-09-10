package Aulas.Exercicios;

import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class CardLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Crie e adicione vários painéis (cartões)
        JPanel card1 = new JPanel();
        card1.add(new JButton("Botão 1"));

        JPanel card2 = new JPanel();
        card2.add(new JButton("Botão 2"));

        cardPanel.add(card1, "card1");
        cardPanel.add(card2, "card2");

        // Botões para alternar entre os cartões
        JButton showCard1Button = new JButton("Mostrar Cartão 1");
        showCard1Button.addActionListener(e -> cardLayout.show(cardPanel, "card1"));

        JButton showCard2Button = new JButton("Mostrar Cartão 2");
        showCard2Button.addActionListener(e -> cardLayout.show(cardPanel, "card2"));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showCard1Button);
        buttonPanel.add(showCard2Button);

        Container contentPane = frame.getContentPane();
        contentPane.add(cardPanel);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
