package aula8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Q3 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculadora Simples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel num1Label = new JLabel("Número 1:");
        JTextField num1Field = new JTextField();

        JLabel num2Label = new JLabel("Número 2:");
        JTextField num2Field = new JTextField();

        JLabel operationLabel = new JLabel("Operação:");
        String[] operations = {"Somar", "Subtrair", "Multiplicar", "Dividir"};
        JComboBox<String> operationsComboBox = new JComboBox<>(operations);

        JCheckBox popupCheckBox = new JCheckBox("Exibir resultado em pop-up");
        JButton calculateButton = new JButton("Calcular");

        JLabel resultTextLabel = new JLabel("Resultado:");
        JLabel resultValueLabel = new JLabel("");

        panel.add(num1Label);
        panel.add(num1Field);
        panel.add(num2Label);
        panel.add(num2Field);
        panel.add(operationLabel);
        panel.add(operationsComboBox);
        panel.add(popupCheckBox);
        panel.add(calculateButton);
        panel.add(resultTextLabel);
        panel.add(resultValueLabel);

        calculateButton.addActionListener((ActionEvent e) -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText().replace(',', '.'));
                double num2 = Double.parseDouble(num2Field.getText().replace(',', '.'));

                String operation = (String) operationsComboBox.getSelectedItem();

                double result = 0;

                switch (operation) {
                    case "Somar":
                        result = num1 + num2;
                        break;
                    case "Subtrair":
                        result = num1 - num2;
                        break;
                    case "Multiplicar":
                        result = num1 * num2;
                        break;
                    case "Dividir":
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(frame, "Erro: Divisão por zero não é permitida.", "Erro de Cálculo", JOptionPane.ERROR_MESSAGE);
                            resultValueLabel.setText("Erro!");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                String formattedResult = String.format("%.2f", result);

                if (popupCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "O resultado é: " + formattedResult, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    resultValueLabel.setText(formattedResult);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos nos campos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                resultValueLabel.setText("Erro!");
            }
        });

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}