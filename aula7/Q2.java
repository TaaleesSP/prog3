package aula7;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String nomeArquivoSaida = "saida.txt";

        try (PrintStream saida = new PrintStream(nomeArquivoSaida)) {
            
            System.out.println("Digite as linhas que deseja gravar no arquivo.");
            System.out.println("Para terminar, digite a palavra FIM e pressione Enter.");

            while (true) {
                String linha = scanner.nextLine();

                if (linha.equals("FIM")) {
                    break;
                }

                saida.println(linha);
            }

            System.out.println("\nArquivo '" + nomeArquivoSaida + "' gravado com sucesso!");

        } catch (FileNotFoundException e) {
            System.err.println("Erro: Não foi possível criar ou escrever no arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}