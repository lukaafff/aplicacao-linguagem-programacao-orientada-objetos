package Aulas.Swing.LayoutManagers;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Spring {
    private static void criarEmostrarGUI() {
        // Criação da janela JFrame
        JFrame frame = new JFrame("Spring");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtenção do painel de conteúdo da janela
        Container contentPane = frame.getContentPane();
        SpringLayout layout = new SpringLayout(); // Criação do SpringLayout

        // Criação de componentes JLabel e JTextField
        JLabel label = new JLabel("Label: ");
        JTextField textField = new JTextField("Meu espaço de texto", 15);

        // Adicionando os componentes ao painel de conteúdo
        contentPane.add(label);
        contentPane.add(textField);

        // Definindo as restrições para os componentes usando SpringLayout
        layout.putConstraint(SpringLayout.WEST, label, 6, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.EAST, contentPane, 6, SpringLayout.EAST, textField);
        layout.putConstraint(SpringLayout.SOUTH, contentPane, 6, SpringLayout.SOUTH, textField);

        // Define o SpringLayout como layout do painel de conteúdo
        contentPane.setLayout(layout);

        // Empacota os componentes dentro do frame
        frame.pack();
        frame.setSize(600, 400); // Define o tamanho da janela
        frame.setVisible(true); // Torna a janela visível
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarEmostrarGUI(); // Chama o método de criação e exibição da GUI
            }
        });
    }
}
