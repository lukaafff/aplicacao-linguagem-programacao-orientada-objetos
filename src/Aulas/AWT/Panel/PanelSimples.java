package Aulas.AWT.Panel;

import java.awt.*;

public class PanelSimples extends Frame {
    Panel p1, p2, p3;

    Label lb1, lb2, lb3;

    PanelSimples() {
        setLayout(new FlowLayout());
        p1 = new Panel();
        lb1 = new Label("Panel 1 red");
        lb1.setForeground(Color.white);
        p1.add(lb1);
        Button bt1 = new Button("Botão 1");
        p1.add(bt1);
        p1.setBackground(Color.red);
        add(p1);

        p2 = new Panel();
        lb2 = new Label("Panel 2 blue");
        lb2.setForeground(Color.white);
        p2.add(lb2);
        Button bt2 = new Button("Botão 2");
        p2.add(bt2);
        p2.setBackground(Color.blue);
        add(p2);
    }

    public static void main(String[] args) {
        Frame PanelSimples = new PanelSimples();
        PanelSimples.setTitle("Exemplo de painel Java AWT");
        PanelSimples.setSize(500,300);
        PanelSimples.setVisible(true);
    }
    
}
