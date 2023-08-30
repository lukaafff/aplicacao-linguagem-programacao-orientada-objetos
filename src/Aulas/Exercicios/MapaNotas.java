package Aulas.Exercicios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MapaNotas {

    JFrame frame;
    JButton btAdd;
    JTextField tf1, tf2, tf3, tf4, tf5;

    public double CalculaMedia(double p1, double p2) {
        return (p1 + p2) / 2;
    }

    public MapaNotas() {
        frame = new JFrame();
        btAdd = new JButton("Adicionar nota");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }
        };
        JTable jt = new JTable(dtm);
        dtm.addColumn("RA");
        dtm.addColumn("Nome");
        dtm.addColumn("P1");
        dtm.addColumn("P2");
        dtm.addColumn("Média");
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                double media = (Double) value;
                if (media >= 7) {
                    c.setForeground(Color.GREEN);
                } else {
                    c.setForeground(Color.RED);
                }
                return c;
            }
        };
        
        jt.getColumnModel().getColumn(4).setCellRenderer(renderer);
        
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.add(new JLabel("RA:"));
        inputPanel.add(tf1);
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(tf2);
        inputPanel.add(new JLabel("Prova 1:"));
        inputPanel.add(tf3);
        inputPanel.add(new JLabel("Prova 2:"));
        inputPanel.add(tf4);
        inputPanel.add(new JSeparator()); //espaçador
        inputPanel.add(btAdd);
    
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double p1 = Double.parseDouble(tf3.getText());
                double p2 = Double.parseDouble(tf4.getText());
                double media = CalculaMedia(p1, p2);
                dtm.addRow(new Object[]{tf1.getText(), tf2.getText(), p1, p2, media});
            }
        });
    
        JPanel inputContainer = new JPanel(new BorderLayout());
        inputContainer.add(inputPanel, BorderLayout.NORTH);
        
        frame.setLayout(new BorderLayout());
        frame.add(inputContainer, BorderLayout.NORTH);
        frame.add(new JScrollPane(jt), BorderLayout.CENTER);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null); //centralizar a tela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MapaNotas();
    }
}
