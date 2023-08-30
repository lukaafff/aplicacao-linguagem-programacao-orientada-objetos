package Aulas.AWT.Frame;

import java.awt.*;

public class FrameSimples extends Frame {
    //construtor
    FrameSimples() {
        //incluir botão
        Button b1 = new Button("Botão 1");
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
        Frame FrameSimples = new FrameSimples();
    }
}
