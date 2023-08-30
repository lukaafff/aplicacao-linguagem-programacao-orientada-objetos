package Aulas.Swing.Frame;

import java.awt.*;
import javax.swing.*;

public class FrameSimples extends JFrame {
    //construtor
    FrameSimples() {
        //incluir botão
        JButton b1 = new JButton("Botão 1");
        //colocar botao no frame
        add(b1);
        //define tamanho do frame
        setSize(500,300);
        //define titulo do frame
        setTitle("Esse é meu primeito exemplo com AWT");
        //define layout do frame
        setLayout(new FlowLayout());
        //torna frame visivel
        setVisible(true);
    }
    //executa codigo
    public static void main(String[] args) {
        JFrame FrameSimples = new FrameSimples();
    }
}

