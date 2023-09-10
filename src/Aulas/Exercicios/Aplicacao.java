package Aulas.Exercicios;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Aplicacao {
    JFrame frame;
    JPanel cardPanel;
    CardLayout cardLayout; // Gerenciador de posicionamento
    JMenuBar menuBar;
    JButton entrarButton, sairButton;
    JPanel jogoVelhaPanel, calculadoraIMCPanel, contatosPanel;
    JTextField pesoTxt, alturaTxt;
    DefaultTableModel tableModel;
    JTable contactTable;
    JButton[][] botoesVelha;
    boolean turnoX;
    
    Aplicacao() {
        frame = new JFrame("Aplicação da Luiza");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Painel inicial
        JPanel inicialPanel = new JPanel();
        inicialPanel.add(new JLabel("Bem-vindo (a) à aplicação da Luiza com Java Swing!"));

        entrarButton = new JButton("Entrar");
        sairButton = new JButton("Sair");

        entrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "login");
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(entrarButton);
        buttonPanel.add(sairButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Painel de login
        JPanel loginPanel = new JPanel(null);

        JLabel usuarioLabel = new JLabel("Usuário: ");
        usuarioLabel.setBounds(20, 50, 80, 30);
        JTextField usuarioField = new JTextField();
        usuarioField.setBounds(100, 50, 150, 30);

        JLabel senhaLabel = new JLabel("Senha: ");
        senhaLabel.setBounds(20, 90, 80, 30);
        JPasswordField senhaField = new JPasswordField();
        senhaField.setBounds(100, 90, 150, 30);

        JButton entrarLoginButton = new JButton("Entrar");
        entrarLoginButton.setBounds(100, 130, 150, 30);

        entrarLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuarioDigitado = usuarioField.getText();
                char[] senhaDigitada = senhaField.getPassword();

                // Verificar login
                if (usuarioDigitado.equals("luiza") && new String(senhaDigitada).equals("123")) {
                    cardLayout.show(cardPanel, "content");
                    configurarMenu();
                    entrarButton.setVisible(false);
                    sairButton.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "Nome de usuário ou senha incorretos!");
                }

                // Limpar campos
                usuarioField.setText("");
                senhaField.setText("");
            }
        });

        loginPanel.add(usuarioLabel);
        loginPanel.add(usuarioField);
        loginPanel.add(senhaLabel);
        loginPanel.add(senhaField);
        loginPanel.add(entrarLoginButton);

        // Painel após o login
        JPanel contentPanel = new JPanel();
        contentPanel.add(new JLabel("Seja bem-vinda Luiza, use o menu para interagir!"));

        // Painel lista de contatos
        configurarTabelaContatos();

        // Painel jogo da velha
        configurarJogoVelhaPanel();

        // Painel calculadora IMC
        configurarCalculadoraIMCPanel();

        ////
        cardPanel.add(inicialPanel, "inicio");
        cardPanel.add(loginPanel, "login");
        cardPanel.add(contentPanel, "content");
        cardPanel.add(jogoVelhaPanel, "jogoVelha");
        cardPanel.add(contatosPanel, "contatos");
        cardPanel.add(calculadoraIMCPanel, "calculadoraIMC");

        frame.add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    // Método menu
    private void configurarMenu() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem inicioItem = new JMenuItem("Inicio");
        JMenuItem contatosItem = new JMenuItem("Lista de Contatos");
        JMenuItem jogoVelhaItem = new JMenuItem("Jogo da Velha");
        JMenuItem calculadoraIMCItem = new JMenuItem("Calculadora IMC");
        JMenuItem sairItem = new JMenuItem("Sair");

        inicioItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "content");
            }
        });

        contatosItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "contatos");
            }
        });

        jogoVelhaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "jogoVelha");
            }
        });

        calculadoraIMCItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "calculadoraIMC");
            }
        });

        sairItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(inicioItem);
        menu.add(contatosItem);
        menu.add(jogoVelhaItem);
        menu.add(calculadoraIMCItem);
        menu.add(sairItem);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    // Método configurar tabela de contatos
    private void configurarTabelaContatos() {
        contatosPanel = new JPanel(new BorderLayout());

        // Cabeçalhos das colunas
        String[] columnNames = {"Nome", "Email", "Telefone"};

        // Modelo da tabela vazia
        tableModel = new DefaultTableModel(new Object[][]{}, columnNames);

        // Crie a tabela com o modelo
        contactTable = new JTable(tableModel);

        // Adicione a tabela a um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // Botões para adicionar e excluir contatos
        JButton adicionarContatoButton = new JButton("Adicionar Contato");
        JButton excluirContatoButton = new JButton("Excluir Contato");

        adicionarContatoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarContato();
            }
        });

        excluirContatoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirContato();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(adicionarContatoButton);
        buttonPanel.add(excluirContatoButton);

        contatosPanel.add(scrollPane, BorderLayout.CENTER);
        contatosPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Método para adicionar um novo contato
    private void adicionarContato() {
        String nome = JOptionPane.showInputDialog(frame, "Digite o nome do contato:");
        //se o nome nao é nulo e apos a remoção dos espaços em barncos (trim) e o nome nao continua vazio (empty)
        if (nome != null && !nome.trim().isEmpty()) {
            String email = JOptionPane.showInputDialog(frame, "Digite o email do contato:");
            if (email != null && !email.trim().isEmpty()) {
                String telefone = JOptionPane.showInputDialog(frame, "Digite o telefone do contato:");
                if (telefone != null && !telefone.trim().isEmpty()) {
                    // Adicione o contato na tabela
                    tableModel.addRow(new Object[]{nome, email, telefone});
                } 
                //campos em branco ou cancelar
                else {
                    JOptionPane.showMessageDialog(frame, "Telefone inválido. O contato não foi adicionado.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Email inválido. O contato não foi adicionado.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Nome inválido. O contato não foi adicionado.");
        }
    }

    // Método para excluir o contato selecionado na tabela
    private void excluirContato() {
        //obtem o indice da linha selecionada
        int selectedRow = contactTable.getSelectedRow();
        //linha selecionada
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(frame, "Tem certeza de que deseja excluir este contato?",
                    "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione um contato para excluir.");
        }
    }

    // Método configurar o painel do jogo da velha
    private void configurarJogoVelhaPanel() {
        jogoVelhaPanel = new JPanel();
        jogoVelhaPanel.setLayout(new GridLayout(3, 3));

        botoesVelha = new JButton[3][3];
        turnoX = true;

        //criar botoes e configurar
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.PLAIN, 48));
                botoesVelha[i][j] = button;

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //se o botão estiver vazio e o jogo nao foi vencido
                        if (button.getText().equals("") && !verificarVitoria()) {
                            //se é o turno do X
                            if (turnoX) {
                                button.setText("X");
                            } else {
                                button.setText("O");
                            }
                            turnoX = !turnoX;
                        }
                    }
                });
                jogoVelhaPanel.add(button);
            }
        }
    }

    // Método para verificar se alguém ganhou o jogo
    private boolean verificarVitoria() {
        // Mostrar estado atual do jogo
        String[][] campo = new String[3][3];
        // Copiar o estado atual dos botões para a matriz campo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                campo[i][j] = botoesVelha[i][j].getText();
            }
        }
        // Verificar linhas, colunas e diagonais
        for (int i = 0; i < 3; i++) {
            if (campo[i][0].equals(campo[i][1]) && campo[i][1].equals(campo[i][2]) && !campo[i][0].equals("")) {
                JOptionPane.showMessageDialog(frame, campo[i][0] + " ganhou!");
                reiniciarJogo();
                return true;
            }
            if (campo[0][i].equals(campo[1][i]) && campo[1][i].equals(campo[2][i]) && !campo[0][i].equals("")) {
                JOptionPane.showMessageDialog(frame, campo[0][i] + " ganhou!");
                reiniciarJogo();
                return true;
            }
        }
        if (campo[0][0].equals(campo[1][1]) && campo[1][1].equals(campo[2][2]) && !campo[0][0].equals("")) {
            JOptionPane.showMessageDialog(frame, campo[0][0] + " ganhou!");
            reiniciarJogo();
            return true;
        }
        if (campo[0][2].equals(campo[1][1]) && campo[1][1].equals(campo[2][0]) && !campo[0][2].equals("")) {
            JOptionPane.showMessageDialog(frame, campo[0][2] + " ganhou!");
            reiniciarJogo();
            return true;
        }
        // Verificar empate
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (campo[i][j].equals("")) {
                    empate = false;
                    break;
                }
            }
            if (!empate) {
                break;
            }
        }
        if (empate) {
            JOptionPane.showMessageDialog(frame, "Empate!");
            reiniciarJogo();
            return true;
        }
        return false;
    }

    // Método para reiniciar o jogo
    private void reiniciarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoesVelha[i][j].setText("");
            }
        }
        turnoX = true;
    }

    // Método calculadora IMC
    private void configurarCalculadoraIMCPanel() {
        calculadoraIMCPanel = new JPanel(null);

        JLabel pesoLabel = new JLabel("Peso (kg): ");
        pesoLabel.setBounds(20, 20, 100, 20);
        pesoTxt = new JTextField(10);
        pesoTxt.setBounds(130, 20, 100, 20);

        JLabel alturaLabel = new JLabel("Altura (m): ");
        alturaLabel.setBounds(20, 50, 100, 20);
        alturaTxt = new JTextField(10);
        alturaTxt.setBounds(130, 50, 100, 20);

        JButton calcularButton = new JButton("Calcular IMC");
        calcularButton.setBounds(20, 80, 150, 20);

        JLabel resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setBounds(20, 110, 200, 20);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularIMC(resultadoLabel);
            }
        });

        calculadoraIMCPanel.add(pesoLabel);
        calculadoraIMCPanel.add(pesoTxt);
        calculadoraIMCPanel.add(alturaLabel);
        calculadoraIMCPanel.add(alturaTxt);
        calculadoraIMCPanel.add(calcularButton);
        calculadoraIMCPanel.add(resultadoLabel);
    }

    private void calcularIMC(JLabel resultadoLabel) {
        try {
            double peso = Double.parseDouble(pesoTxt.getText());
            double altura = Double.parseDouble(alturaTxt.getText());

            double imc = peso / (altura * altura);

            DecimalFormat df = new DecimalFormat("#.##");
            String imcFormatado = df.format(imc);

            resultadoLabel.setText("Resultado: IMC " + imcFormatado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Digite valores válidos para peso e altura.");
        }
    }

    public static void main(String[] args) {
        new Aplicacao();
    }
}
