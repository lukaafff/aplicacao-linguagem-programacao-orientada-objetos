package Aulas.Swing.Eventos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculaIMC implements ActionListener {
	JFrame f;
	JPanel panel;
	JTextField pesoTxt, alturaTxt;

	CalculaIMC() {
		// Cria o container
		f = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		JLabel pesoLbl = new JLabel("Peso:");
		pesoLbl.setBounds(20, 20, 100, 20);
		pesoTxt = new JTextField();
		pesoTxt.setBounds(20, 50, 100, 20);
		JLabel alturaLbl = new JLabel("Altura:");
		alturaLbl.setBounds(20, 80, 100, 20);
		alturaTxt = new JTextField();
		alturaTxt.setBounds(20, 110, 100, 20);
		JButton b1 = new JButton("Calcula");
		b1.setBounds(20, 140, 100, 20);
		b1.addActionListener(this);
		// Inclui componentes
		panel.add(pesoLbl);
		panel.add(pesoTxt);
		panel.add(alturaLbl);
		panel.add(alturaTxt);
		panel.add(b1);

		f.setSize(150, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(panel);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new CalculaIMC();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Double peso = Double.parseDouble(pesoTxt.getText());
		Double altura = Double.parseDouble(alturaTxt.getText());
		double imc = peso / (altura * altura);
		String msg = "Seu IMC é: " + imc;
		JOptionPane.showMessageDialog(f, msg);

	}
}