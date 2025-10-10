package aula8;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Q1 {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Minha Janela Java");
        janela.setSize(400, 300);
        JLabel label = new JLabel("boas-vindas");
        label.setBounds(160, 50, 100, 30);
        janela.add(label);
        JButton botao = new JButton("Fechar");
        botao.setBounds(150, 100, 100, 30);
        janela.add(botao);
        janela.setLayout(null);
        botao.addActionListener(e -> janela.dispose());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
