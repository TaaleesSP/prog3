package Trabalho;

import javax.swing.SwingUtilities;

public class Inicio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BibliotecaGUI().setVisible(true);
        });
    }
}