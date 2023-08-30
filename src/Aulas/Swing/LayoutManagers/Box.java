package Aulas.Swing.LayoutManagers;

import java.awt.*;
import javax.swing.*;

public class Box extends Frame {
    Button buttons[];

    public Box () {
        buttons = new Button[5];

        for (int i = 0; i < 5; i++) {
            buttons[i] = new Button("Botão " + (i +1));
            add(buttons[i]);
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Box b = new Box();
    }
}
