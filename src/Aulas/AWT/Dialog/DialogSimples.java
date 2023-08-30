package Aulas.AWT.Dialog;

import java.awt.*;
import java.awt.event.*;

public class DialogSimples {
    public static void main(String[] args) {
        Frame frame = new Frame("Exemplo de dialogo com Java AWT");
        frame.setLayout(new FlowLayout());
        frame.setSize(400,400);
        frame.setBackground(Color.white);
        frame.setVisible(true);

        Dialog d1 = new Dialog(null, true);
        d1.setLayout(new FlowLayout());
        d1.setTitle("Dialogo Java");
        d1.setSize(400,200);
        d1.setBackground(Color.gray);

        Button bt1 = new Button("Botão 1");
        bt1.setSize(20,10);
        d1.add(bt1);
        d1.setVisible(true);
    }
}
